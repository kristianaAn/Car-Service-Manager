package com.example.car_service_schedule.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Car extends BaseEntity {
    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int year;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private EngineTypes engineType;

    @Column(name = "cubic_capacity", nullable = false)
    private double cubicCapacity;

    @OneToMany(targetEntity = CarPartForChange.class, mappedBy = "car")
    private List<CarPartForChange> carPartForChangesList;

    @ManyToOne
    @JoinColumn(name = "mechanic", referencedColumnName = "id")
    private Mechanic mechanic;

    @ManyToOne
    @JoinColumn(name = "customer", referencedColumnName = "id")
    private Customer owner;

    @Column(columnDefinition = "TEXT")
    private String notes;
}
