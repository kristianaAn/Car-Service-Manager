package com.example.car_service_schedule.repositories;

import com.example.car_service_schedule.models.Car;
import com.example.car_service_schedule.models.EngineTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {
    Car findCarByBrand(String brand);
    Car findCarByEngineType(EngineTypes engineTypes);
}
