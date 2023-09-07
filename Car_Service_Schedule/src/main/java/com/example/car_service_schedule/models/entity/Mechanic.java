package com.example.car_service_schedule.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "mechanics")
@Getter
@Setter
@NoArgsConstructor
public class Mechanic extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(targetEntity = Car.class, mappedBy = "mechanic")
    private List<Car> carList;

    @ManyToMany
    private List<Customer> customers;

}
