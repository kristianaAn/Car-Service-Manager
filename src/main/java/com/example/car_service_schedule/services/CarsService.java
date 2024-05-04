package com.example.car_service_schedule.services;

import com.example.car_service_schedule.models.entity.Car;
import com.example.car_service_schedule.models.entity.Customer;

public interface CarsService {
    void addNewCar(Car car);
    Car findCarByBrand(String brand);
}
