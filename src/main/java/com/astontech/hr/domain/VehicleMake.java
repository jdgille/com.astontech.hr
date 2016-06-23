package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jonagill1 on 6/22/2016.
 */

@Entity
public class VehicleMake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleMakeId")
    private Integer id;

    @Version
    private Integer version;

    private String vehicleMakeName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VehicleModel> vehicleModelList;

    public VehicleMake(){}

    public VehicleMake(String vehicleMakeName){
        this.setVehicleMakeName(vehicleMakeName);
    }

    public VehicleMake(String vehicleMakeName, List<VehicleModel> vehicleModelList){
        this.setVehicleMakeName(vehicleMakeName);
        this.setVehicleModelList(vehicleModelList);
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

    public String getVehicleMakeName() {
        return vehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }

    public List<VehicleModel> getVehicleModelList() {
        return vehicleModelList;
    }

    public void setVehicleModelList(List<VehicleModel> vehicleModelList) {
        this.vehicleModelList = vehicleModelList;
    }
}
