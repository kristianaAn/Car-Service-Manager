package models.carSpecialist;

import models.carsForService.Car;

import java.util.Map;

public interface CarSpecialist {
    String getName();

    Map<Integer, Car> getCars();
}
