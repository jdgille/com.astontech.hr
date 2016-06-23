package com.astontech.hr.domain;

import javax.persistence.*;

/**
 * Created by jonagill1 on 6/22/2016.
 */

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleId")
    private Integer id;

    @Version
    private Integer version;

    private String vehicleName;

    public Vehicle(){}

    public Vehicle(String vehicleName){
        this.setVehicleName(vehicleName);
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

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
