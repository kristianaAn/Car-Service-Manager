package com.example.car_service_schedule.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car_parts_for_change")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarPartForChange extends BaseEntity {
    @Column(name = "part_name")
    private String partName;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
}
