package models.customers;

import models.carsForService.Car;
import outputMessages.ExceptionMessages;

public abstract class Customer {
    private String name;
    private String phoneNumber;
    private Car car;

    public Customer(String name, String phoneNumber, Car car) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setCar(car);
    }

    private boolean nullInput (String text) {
        return text == null || text.trim().isEmpty();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (nullInput(name)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CUSTOMER_NAME);
        }
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (nullInput(phoneNumber)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PHONE_NUMBER);
        }
        this.phoneNumber = phoneNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
