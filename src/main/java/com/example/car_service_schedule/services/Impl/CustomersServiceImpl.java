package com.example.car_service_schedule.services.Impl;

import com.example.car_service_schedule.models.entity.Customer;
import com.example.car_service_schedule.repositories.CustomersRepository;
import com.example.car_service_schedule.services.CustomersService;
import org.springframework.stereotype.Service;

@Service
public class CustomersServiceImpl implements CustomersService {
    private final CustomersRepository customersRepository;

    public CustomersServiceImpl(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public void addNewCustomer(Customer customer) {
        this.customersRepository.save(customer);
    }

    @Override
    public Customer findCustomerByName(String name) {
        return this.customersRepository.findCustomerByName(name);
    }

    @Override
    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        return this.customersRepository.findCustomerByPhoneNumber(phoneNumber);
    }
}
