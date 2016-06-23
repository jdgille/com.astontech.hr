package com.astontech.hr.rest;

import com.astontech.hr.domain.Person;
import com.astontech.hr.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jonagill1 on 6/23/2016.
 */

@RestController
@RequestMapping("/api/person")
public class PersonRest {

    @Autowired
    PersonService personService;

    @RequestMapping("/list")
    public Iterable<Person> listAllPeople(){
        return personService.listAllPeople();
    }

    @RequestMapping(value="/list", method = RequestMethod.POST)
    public Person savePerson(@RequestBody Person person){
        return personService.savePerson(person);
    }


}
