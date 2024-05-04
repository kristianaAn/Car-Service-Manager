package com.example.car_service_schedule.repositories;

import com.example.car_service_schedule.models.entity.softUsers.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
      Optional<Users> findByUsernameAndPassword(String username, String password);
}
