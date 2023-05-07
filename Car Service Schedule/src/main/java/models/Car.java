package models;

import outputMessages.ExceptionMessages;

import java.util.LinkedHashSet;
import java.util.Set;

public class Car {
    private String brand;
    private String model;
    private Set<String> partsForChange;

    public Car(String brand, String model) {
        setBrand(brand);
        setModel(model);
        this.partsForChange = new LinkedHashSet<>();
    }

    private boolean nullInput (String word) {
        return word == null || word.trim().isEmpty();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (nullInput(brand)) {
            throw new IllegalArgumentException(ExceptionMessages.NULL_BRAND);
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (nullInput(model)) {
            throw new IllegalArgumentException(ExceptionMessages.NULL_MODEL);
        }
        this.model = model;
    }

    public Set<String> getPartsForChange() {
        return partsForChange;
    }

    public void setPartsForChange(Set<String> partsForChange) {
        this.partsForChange = partsForChange;
    }
}
