package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleModel;

/**
 * Created by jonagill1 on 6/22/2016.
 */
public interface VehicleModelService {

    Iterable<VehicleModel> listAllVehicleModels();

    VehicleModel getVehicleModelById(Integer id);

    VehicleModel saveVehicleModel(VehicleModel vehicleModel);

    Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModelIterable);

    void deleteVehicleModel(Integer id);
}
