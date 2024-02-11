package com.example.car_service_schedule.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "mechanics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mechanic extends BaseEntity {

    @Column
    private String name;

    @OneToMany(targetEntity = Car.class, mappedBy = "mechanic")
    private List<Car> carList;

    @ManyToMany
    private List<Customer> customers;

}
