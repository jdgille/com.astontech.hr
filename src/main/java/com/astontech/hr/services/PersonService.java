package com.astontech.hr.services;

import com.astontech.hr.domain.Person;

/**
 * Created by jonagill1 on 6/23/2016.
 */
public interface PersonService {

    Iterable<Person> listAllPeople();

    Person getPersonById(Integer id);

    Person savePerson(Person person);

    Iterable<Person> savePersonList(Iterable<Person> personIterable);

    void deletePerson(Integer id);
}
