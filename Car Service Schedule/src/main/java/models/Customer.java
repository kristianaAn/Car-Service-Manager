package models;

public abstract class Customer {
    private String name;
    private String phoneNumber;
    private Car car;

    public Customer(String name, String phoneNumber, Car car) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.car = car;
    }
}
