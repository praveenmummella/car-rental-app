package com.carrental;

import com.carrental.model.Car;
import com.carrental.service.CarService;
import com.carrental.service.RentalService;
import java.time.LocalDate;

public class MainApp {
    public static void main(String[] args) {
        CarService carService = new CarService();
        RentalService rentalService = new RentalService(carService);

        // Display available cars
        System.out.println("Available Cars:");
        carService.getAvailableCars().forEach(car -> 
            System.out.println(car.getId() + ": " + car.getMake() + " " + car.getModel()));

        // Rent a car
        Rental rental = rentalService.rentCar("C001", "John Doe", 
            LocalDate.now(), LocalDate.now().plusDays(3));
        
        if (rental != null) {
            System.out.println("\nRental successful:");
            System.out.println("Customer: " + rental.getCustomerName());
            System.out.println("Car: " + rental.getCar().getMake() + " " + rental.getCar().getModel());
            System.out.println("Period: " + rental.getStartDate() + " to " + rental.getEndDate());
        }

        // Display rentals
        System.out.println("\nCurrent Rentals:");
        rentalService.getAllRentals().forEach(r -> 
            System.out.println(r.getId() + ": " + r.getCustomerName() + " - " + 
                r.getCar().getMake() + " " + r.getCar().getModel()));
    }
}
