package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;

/**
 * Created by jonagill1 on 6/22/2016.
 */
public interface VehicleMakeService {

    Iterable<VehicleMake> listAllVehicleMakes();

    VehicleMake getVehicleMakeById(Integer id);

    VehicleMake saveVehicleMake(VehicleMake vehicleMake);

    Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeIterable);

    void deleteVehicleMake(Integer id);
}
