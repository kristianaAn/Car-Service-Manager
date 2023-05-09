package models.carSpecialist;

import models.carsForService.Car;
import outputMessages.ExceptionMessages;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class CarSpecialists implements CarSpecialist {
    private String name;
    private Map<Integer, Car> carsToService;

    public CarSpecialists(String name) {
        setName(name);
        this.carsToService = new LinkedHashMap<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Map<Integer, Car> getCars() {
        return this.carsToService;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CAR_SPECIALIST_NAME);
        }
        this.name = name;
    }

    public void setCarsToService(Map<Integer, Car> carsToService) {
        this.carsToService = carsToService;
    }
}
