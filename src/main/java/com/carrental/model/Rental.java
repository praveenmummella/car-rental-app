package com.carrental.model;

import java.time.LocalDate;

public class Rental {
    private String id;
    private Car car;
    private String customerName;
    private LocalDate startDate;
    private LocalDate endDate;

    public Rental(String id, Car car, String customerName, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.car = car;
        this.customerName = customerName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters
    public String getId() { return id; }
    public Car getCar() { return car; }
    public String getCustomerName() { return customerName; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
}
