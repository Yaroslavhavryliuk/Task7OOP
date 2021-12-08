package com.tasks.example.entity;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
    private String model;
    private int year;
    private String country;

    public Car(String model, int year, String country) {
        this.model = model;
        this.year = year ;
        this.country = country;
    }
}