package com.carrental.model;

public class Car {
    private String id;
    private String make;
    private String model;
    private int year;
    private boolean available;

    public Car(String id, String make, String model, int year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.available = true;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
