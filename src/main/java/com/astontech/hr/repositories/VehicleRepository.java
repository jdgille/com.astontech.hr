package com.astontech.hr.repositories;

import com.astontech.hr.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jonagill1 on 6/22/2016.
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
}
