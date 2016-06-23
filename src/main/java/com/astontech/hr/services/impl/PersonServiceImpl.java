package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Person;
import com.astontech.hr.repositories.PersonRepository;
import com.astontech.hr.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jonagill1 on 6/23/2016.
 */

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Iterable<Person> listAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Integer id) {
        return personRepository.findOne(id);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Iterable<Person> savePersonList(Iterable<Person> personIterable) {
        return personRepository.save(personIterable);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.delete(id);
    }
}
