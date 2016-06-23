package com.astontech.hr.domain;

import javax.persistence.*;

/**
 * Created by jonagill1 on 6/23/2016.
 */

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PersonId")
    private Integer id;

    @Version
    private Integer version;

    private String personFirstName;
    private String personLastName;

    public Person(){}

    public Person(String personFirstName, String personLastName){
        this.setPersonFirstName(personFirstName);
        this.setPersonLastName(personLastName);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }
}
