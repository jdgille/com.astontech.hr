package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.domain.Person;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonagill1 on 6/21/2016.
 */
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private PersonService personService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        generateElementAndElementTypes();
        generatePeople();

    }

    private void generateElementAndElementTypes(){

        ElementType laptopType = new ElementType("Laptop");
        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));

        laptopType.setElementList(elementList);

        elementTypeService.saveElementType(laptopType);

        elementList.clear();

        ElementType phoneType = new ElementType("Phone");
        elementList.add(new Element("iPhone 6"));
        elementList.add(new Element("iPhone 6+"));
        elementList.add(new Element("Galaxy S"));
        elementList.add(new Element("Galaxy S1"));
        elementList.add(new Element("Galaxy Nexus"));

        phoneType.setElementList(elementList);

        elementTypeService.saveElementType(phoneType);
    }

    private void generatePeople(){

        personService.savePerson(new Person("Jon", "Gille"));
        personService.savePerson(new Person("Joe", "Schmuck"));
        personService.savePerson(new Person("Bipin", "Bitula"));
        personService.savePerson(new Person("Darth", "Vador"));
        personService.savePerson(new Person("Ella", "Vador"));

    }
}
