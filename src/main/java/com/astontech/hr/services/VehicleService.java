package com.astontech.hr.services;

import com.astontech.hr.domain.Vehicle;

/**
 * Created by jonagill1 on 6/22/2016.
 */
public interface VehicleService {

    Iterable<Vehicle> listAllVehicles();

    Vehicle getVehicleById(Integer id);

    Vehicle saveVehicle(Vehicle vehicle);

    Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleIterable);

    void deleteVehicle(Integer id);
}
