package models.carSpecialist;

import models.carsForService.Car;

import java.util.Map;

public interface carSpecialistImpl {
    String getName();

    Map<Integer, Car> getCars();
}
