package com.astontech.hr.controllers;

import com.astontech.hr.domain.*;
import com.astontech.hr.domain.VO.ElementVO;
import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonagill1 on 6/21/2016.
 */
@Controller
public class AdminController {

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    private Logger log = Logger.getLogger(AdminController.class);

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminHome(){
        return "admin/adminHome";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.GET)
    public String adminElementGet(Model model){
        model.addAttribute("elementVO", new ElementVO());
        model.addAttribute("warningAlert", "visible");
        return "admin/element/element_add";
    }

    @RequestMapping(value="/admin/element/add", method = RequestMethod.POST)
    public String adminElementPost(ElementVO elementVO, Model model){
        elementVO.splitNewElementsIntoArray();
        logElementVo(elementVO);

        saveElementTypeAndElementFromVO(elementVO);

        boolean success = true;
        if(success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        model.addAttribute("elementVO",new ElementVO());

        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/list", method = RequestMethod.GET)
    public String adminElementList(Model model){
        model.addAttribute("elementTypeList", elementTypeService.listAllElementTypes());
        return "admin/element/element_list";
    }

    @RequestMapping(value = "/admin/element/edit/{id}", method = RequestMethod.GET)
    public String elementTypeEdit(@PathVariable int id, Model model){
        ElementType elementType = elementTypeService.getElementTypeById(id);

        model.addAttribute("elementType", elementType);

        return "admin/element/element_edit";
    }

    @RequestMapping(value = "/admin/element/delete/{id}", method = RequestMethod.GET)
    public String elementTypeDelete(@PathVariable int id){
        elementTypeService.deleteElementType(id);

        return "redirect:/admin/element/list";
    }

    @RequestMapping(value = "/admin/element/update", method = RequestMethod.POST)
    public String elementTypeUpdate(ElementType elementType,
                                    Model model,
                                    @RequestParam("inputNewElement") String newElement){
        // if newElement (unbound textbox has a value you add it to the list
        if(!newElement.equals("")){
            if(elementType.getElementList()==null){
                List<Element> elementList = new ArrayList<>();
                elementList.add(new Element(newElement));
                elementType.setElementList(elementList);
            }else {
                elementType.getElementList().add(new Element(newElement));
            }
        }

        //iterate through the list of elements
        for(int i = 0; i<elementType.getElementList().size(); i++){
            // check to see if element name is empty
            if(elementType.getElementList().get(i).getElementName().equals("")){
                elementType.getElementList().remove(i);
            }
        }

        elementTypeService.saveElementType(elementType);
        return "redirect:/admin/element/edit/" + elementType.getId();
    }

    @RequestMapping(value="/admin/vehicle/make/add", method = RequestMethod.POST)
    public String adminVehicleMakePost(VehicleVO vehicleVO, Model model){
        VehicleMake vehicleMake = new VehicleMake(vehicleVO.getNewVehicleMake());
        vehicleMakeService.saveVehicleMake(vehicleMake);

        return "redirect:/admin/vehicle/make/add";
    }

    @RequestMapping(value = "/admin/vehicle/make/add", method = RequestMethod.GET)
    public String adminVehicleMakeGet(VehicleVO vehicleVO, Model model){
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("warningAlert", "visible");
        return "admin/vehicle/vehicleMake_add";
    }

    @RequestMapping(value="/admin/vehicle/model/add", method = RequestMethod.POST)
    public String adminVehicleModelPost(VehicleModel vehicleModel,
                                        Model model,
                                        @RequestParam("selectMake")Integer selectedMakeId){

        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(selectedMakeId);
        vehicleMake.getVehicleModelList().add(vehicleModel);
        vehicleMakeService.saveVehicleMake(vehicleMake);

        return "redirect:/admin/vehicle/model/add";
    }

    @RequestMapping(value = "/admin/vehicle/model/add", method = RequestMethod.GET)
    public String adminVehicleModelGet(Model model){
        model.addAttribute("vehicleModel", new VehicleModel());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("warningAlert", "visible");

        return "admin/vehicle/vehicleModel_add";
    }

    @RequestMapping(value = "/admin/vehicle/vehicle/add", method = RequestMethod.GET)
    public String adminVehicleGet(Model model){
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        model.addAttribute("warningAlert", "visible");

        return "admin/vehicle/vehicle_add";
    }


    //// not sure how to add two request params
    @RequestMapping(value="/admin/vehicle/vehicle/add", method = RequestMethod.POST)
    public String adminVehicleModelPost(Vehicle vehicle,
                                        Model model,
                                        @RequestParam("selectMake")Integer selectedMakeId,
                                        @RequestParam("selectModel")Integer selectedModelId){

        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(selectedMakeId);
        vehicleMake.getVehicleModelList().get(selectedModelId);
        vehicleMakeService.saveVehicleMake(vehicleMake);

        return "redirect:/admin/vehicle/model/add";
    }

    @RequestMapping(value = "/admin/vehicle/make/list", method = RequestMethod.GET)
    public String adminVehicleMakeList(Model model){
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());
        return "admin/vehicle/vehicleMake_list";
    }

    @RequestMapping(value = "/admin/vehicle/make/edit/{id}", method = RequestMethod.GET)
    public String vehicleMakeEdit(@PathVariable int id, Model model){
        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(id);

        model.addAttribute("vehicleMake", vehicleMake);

        return "admin/vehicle/vehicleMake_edit";
    }

    @RequestMapping(value = "/admin/vehicle/make/update", method = RequestMethod.POST)
    public String vehicleMakeUpdate(VehicleMake vehicleMake,
                                    Model model,
                                    @RequestParam("inputNewVehicleModel") String newVehicleModel){
        // if newVehicleMake (unbound textbox has a value you add it to the list
        if(!newVehicleModel.equals("")){
            if(vehicleMake.getVehicleModelList()==null){
                List<VehicleModel> vehicleModelList = new ArrayList<VehicleModel>();
                vehicleModelList.add(new VehicleModel(newVehicleModel));
                vehicleMake.setVehicleModelList(vehicleModelList);
            }else {
                vehicleMake.getVehicleModelList().add(new VehicleModel(newVehicleModel));
            }
        }

        //iterate through the list of elements
        for(int i = 0; i<vehicleMake.getVehicleModelList().size(); i++){
            // check to see if element name is empty
            if(vehicleMake.getVehicleModelList().get(i).getVehicleModelName().equals("")){
                vehicleMake.getVehicleModelList().remove(i);
            }
        }

        vehicleMakeService.saveVehicleMake(vehicleMake);
        return "redirect:/admin/vehicle/make/edit/" + vehicleMake.getId();
    }

    @RequestMapping(value = "/admin/vehicle/model/edit/{id}", method = RequestMethod.GET)
    public String vehicleModelEdit(@PathVariable int id, Model model){
        VehicleModel vehicleModel = vehicleModelService.getVehicleModelById(id);

        model.addAttribute("vehicleModel", vehicleModel);

        return "admin/vehicle/vehicleModel_edit";
    }

    @RequestMapping(value = "/admin/vehicle/model/update", method = RequestMethod.POST)
    public String vehicleModelUpdate(VehicleModel vehicleModel,
                                    Model model,
                                    @RequestParam("inputNewVehicle") String newVehicle){
        // if newVehicleModel (unbound textbox has a value you add it to the list
        if(!newVehicle.equals("")){
            if(vehicleModel.getVehicleList()==null){
                List<Vehicle> vehicleList = new ArrayList<Vehicle>();
                vehicleList.add(new Vehicle(newVehicle));
                vehicleModel.setVehicleList(vehicleList);
            }else {
                vehicleModel.getVehicleList().add(new Vehicle(newVehicle));
            }
        }

        //iterate through the list of elements
        for(int i = 0; i<vehicleModel.getVehicleList().size(); i++){
            // check to see if element name is empty
            if(vehicleModel.getVehicleList().get(i).getVehicleName().equals("")){
                vehicleModel.getVehicleList().remove(i);
            }
        }

        vehicleModelService.saveVehicleModel(vehicleModel);
        return "redirect:/admin/vehicle/model/edit/" + vehicleModel.getId();
    }

    @RequestMapping(value = "/admin/vehicle/make/delete/{id}", method = RequestMethod.GET)
    public String vehicleMakeDelete(@PathVariable int id){
        vehicleMakeService.deleteVehicleMake(id);

        return "redirect:/admin/vehicle/make/list";
    }


    private void logElementVo(ElementVO elementVO) {
        log.info("New Element Type: " + elementVO.getNewElementType());
        // regex for splitting on a new line or carriage return is \\r \\n

        for (String str : elementVO.getNewElementArray()) {
            log.info("New Element: " + str);
        }
    }

    private void saveElementTypeAndElementFromVO(ElementVO elementVO){

        List<Element> newElementList = new ArrayList<Element>();
        for(String str : elementVO.getNewElementArray()){
            newElementList.add(new Element(str));
        }
        ElementType newElementType = new ElementType(elementVO.getNewElementType());
        newElementType.setElementList(newElementList);

        elementTypeService.saveElementType(newElementType);
    }

}
