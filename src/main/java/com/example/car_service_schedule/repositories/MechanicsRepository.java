package com.example.car_service_schedule.repositories;

import com.example.car_service_schedule.models.entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicsRepository extends JpaRepository<Mechanic, Long> {

//    Mechanic findMechanicByCarList(List<Car> carList);
}
