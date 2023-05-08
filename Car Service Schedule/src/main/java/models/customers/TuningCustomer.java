package models.customers;

import models.carsForService.Car;

public class TuningCustomer extends Customer{

    public TuningCustomer(String name, String phoneNumber, Car car) {
        super(name, phoneNumber, car);
    }
}
