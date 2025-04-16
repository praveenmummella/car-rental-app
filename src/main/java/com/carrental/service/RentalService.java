package com.carrental.service;

import com.carrental.model.Car;
import com.carrental.model.Rental;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RentalService {
    private CarService carService;
    private List<Rental> rentals = new ArrayList<>();

    public RentalService(CarService carService) {
        this.carService = carService;
    }

    public Rental rentCar(String carId, String customerName, LocalDate startDate, LocalDate endDate) {
        if (carService.rentCar(carId)) {
            Car car = carService.getCarById(carId).get();
            String rentalId = UUID.randomUUID().toString();
            Rental rental = new Rental(rentalId, car, customerName, startDate, endDate);
            rentals.add(rental);
            return rental;
        }
        return null;
    }

    public boolean returnCar(String rentalId) {
        Optional<Rental> rental = rentals.stream()
                .filter(r -> r.getId().equals(rentalId))
                .findFirst();
        
        if (rental.isPresent()) {
            boolean returned = carService.returnCar(rental.get().getCar().getId());
            if (returned) {
                rentals.remove(rental.get());
                return true;
            }
        }
        return false;
    }

    public List<Rental> getAllRentals() {
        return new ArrayList<>(rentals);
    }
}
