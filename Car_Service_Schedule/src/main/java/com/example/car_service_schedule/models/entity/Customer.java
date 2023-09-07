package com.example.car_service_schedule.models.entity;

import com.example.car_service_schedule.models.entity.BaseEntity;
import com.example.car_service_schedule.models.entity.Car;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {

    @Column (nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column (name = "service_description", nullable = false)
    private String serviceDescription;

    @OneToMany(targetEntity = Car.class, mappedBy = "owner")
    private List<Car> cars;

    @Column(nullable = false)
    private BigDecimal bill;

    @Column
    private boolean billIsPaid;
}
