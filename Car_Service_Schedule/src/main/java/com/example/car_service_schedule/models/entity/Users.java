package com.example.car_service_schedule.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Users extends BaseEntity{

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column (nullable = false)
    private Roles role;

    @OneToOne
    private Mechanic mechanic;

}
