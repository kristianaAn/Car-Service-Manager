package com.example.car_service_schedule.models.entity.softUsers;

import com.example.car_service_schedule.models.entity.BaseEntity;
import com.example.car_service_schedule.models.entity.Mechanic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Users extends BaseEntity {

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private Date created;

    @Enumerated(value = EnumType.STRING)
    @Column (nullable = false)
    private Roles role;

    @OneToOne
    private Mechanic mechanic;

}
