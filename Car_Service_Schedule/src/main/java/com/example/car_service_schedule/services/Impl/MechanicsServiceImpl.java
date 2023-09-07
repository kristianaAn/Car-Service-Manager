package com.example.car_service_schedule.services.Impl;

import com.example.car_service_schedule.models.entity.Mechanic;
import com.example.car_service_schedule.repositories.MechanicsRepository;
import com.example.car_service_schedule.services.MechanicsService;
import org.springframework.stereotype.Service;

@Service
public class MechanicsServiceImpl implements MechanicsService {
    private final MechanicsRepository mechanicsRepository;

    public MechanicsServiceImpl(MechanicsRepository mechanicsRepository) {
        this.mechanicsRepository = mechanicsRepository;
    }

    @Override
    public void addNewMechanic(Mechanic mechanic) {
        this.mechanicsRepository.save(mechanic);
    }
}
