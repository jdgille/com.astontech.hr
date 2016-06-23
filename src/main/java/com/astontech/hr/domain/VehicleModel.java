package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jonagill1 on 6/22/2016.
 */

@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleModelId")
    private Integer id;

    @Version
    private Integer version;

    private String vehicleModelName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vehicle> vehicleList;

    public VehicleModel(){}

    public VehicleModel(String vehicleModelName){
        this.setVehicleModelName(vehicleModelName);
    }

    public VehicleModel(String vehicleModelName, List<Vehicle> vehicleList){
        this.setVehicleModelName(vehicleModelName);
        this.setVehicleList(vehicleList);
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

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
