package models.customers;

import models.carsForService.Car;

public class CarServiceCustomer extends Customer{

    public CarServiceCustomer(String name, String phoneNumber, Car car) {
        super(name, phoneNumber, car);
    }
}
