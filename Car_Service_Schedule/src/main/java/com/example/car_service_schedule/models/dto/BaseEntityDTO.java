package com.example.car_service_schedule.models.dto;

public class BaseEntityDTO {
    private long id;

    public BaseEntityDTO(long id) {
        this.id = id;
    }

    public BaseEntityDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
