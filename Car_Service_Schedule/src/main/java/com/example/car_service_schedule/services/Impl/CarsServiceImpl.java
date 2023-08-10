package com.example.car_service_schedule.services.Impl;

import com.example.car_service_schedule.models.Car;
import com.example.car_service_schedule.repositories.CarsRepository;
import com.example.car_service_schedule.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarsServiceImpl implements CarsService {
    private final CarsRepository carsRepository;

    @Autowired
    public CarsServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public void addNewCar(Car car) {
        this.carsRepository.save(car);
    }

    @Override
    public Car findCarByBrand(String brand) {
        return this.carsRepository.findCarByBrand(brand);
    }
}
