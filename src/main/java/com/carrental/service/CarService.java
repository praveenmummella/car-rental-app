package com.carrental.service;

import com.carrental.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarService {
    private List<Car> cars = new ArrayList<>();

    public CarService() {
        // Initialize with some cars
        cars.add(new Car("C001", "Toyota", "Camry", 2020));
        cars.add(new Car("C002", "Honda", "Accord", 2021));
        cars.add(new Car("C003", "Ford", "Mustang", 2019));
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    public List<Car> getAvailableCars() {
        return cars.stream().filter(Car::isAvailable).toList();
    }

    public Optional<Car> getCarById(String id) {
        return cars.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public boolean rentCar(String carId) {
        Optional<Car> car = getCarById(carId);
        if (car.isPresent() && car.get().isAvailable()) {
            car.get().setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnCar(String carId) {
        Optional<Car> car = getCarById(carId);
        if (car.isPresent() && !car.get().isAvailable()) {
            car.get().setAvailable(true);
            return true;
        }
        return false;
    }
}
