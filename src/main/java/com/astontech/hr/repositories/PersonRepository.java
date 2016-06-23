package com.astontech.hr.repositories;

import com.astontech.hr.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jonagill1 on 6/23/2016.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
