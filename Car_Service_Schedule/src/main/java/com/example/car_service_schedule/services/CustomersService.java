package com.example.car_service_schedule.services;

import com.example.car_service_schedule.models.entity.Customer;

public interface CustomersService {
    void addNewCustomer(Customer customer);
    Customer findCustomerByName(String name);

    Customer findCustomerByPhoneNumber(String phoneNumber);
}
