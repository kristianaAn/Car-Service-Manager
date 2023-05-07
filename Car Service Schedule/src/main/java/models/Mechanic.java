package models;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Mechanic {
    private String name;
    private Map<Integer, Car> carsToService;

    public Mechanic(String name) {
        this.name = name;
        this.carsToService = new LinkedHashMap<>();
    }
}
