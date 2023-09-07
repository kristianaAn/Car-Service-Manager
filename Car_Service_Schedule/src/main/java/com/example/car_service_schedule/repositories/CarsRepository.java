package com.example.car_service_schedule.repositories;

import com.example.car_service_schedule.models.entity.Car;
import com.example.car_service_schedule.models.entity.EngineTypes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {
    Car findCarByBrand(String brand);
    Car findCarByEngineType(EngineTypes engineTypes);

    @Modifying
    @Transactional
    @Query("update Car c set c.owner.name = :customerName")
    void updateCarCustomerName(String customerName);
}
