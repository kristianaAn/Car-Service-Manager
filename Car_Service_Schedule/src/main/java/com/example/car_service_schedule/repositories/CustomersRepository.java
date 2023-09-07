package com.example.car_service_schedule.repositories;

import com.example.car_service_schedule.models.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerById(long id);

    Customer findCustomerByName(String name);

    Customer findCustomerByPhoneNumber(String phoneNumber);
}
