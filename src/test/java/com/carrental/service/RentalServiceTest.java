package com.carrental.service;

import com.carrental.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

class CarServiceTest {
    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @Test
    void getAllCars_shouldReturnAllCars() {
        List<Car> cars = carService.getAllCars();
        assertEquals(3, cars.size());
    }

    @Test
    void getAvailableCars_shouldReturnOnlyAvailableCars() {
        List<Car> availableCars = carService.getAvailableCars();
        assertEquals(3, availableCars.size());
        
        carService.rentCar("C001");
        availableCars = carService.getAvailableCars();
        assertEquals(2, availableCars.size());
    }

    @Test
    void getCarById_shouldReturnCorrectCar() {
        Optional<Car> car = carService.getCarById("C001");
        assertTrue(car.isPresent());
        assertEquals("Toyota", car.get().getMake());
    }

    @Test
    void rentCar_shouldMakeCarUnavailable() {
        boolean result = carService.rentCar("C001");
        assertTrue(result);
        
        Optional<Car> car = carService.getCarById("C001");
        assertTrue(car.isPresent());
        assertFalse(car.get().isAvailable());
    }

    @Test
    void returnCar_shouldMakeCarAvailable() {
        carService.rentCar("C001");
        boolean result = carService.returnCar("C001");
        assertTrue(result);
        
        Optional<Car> car = carService.getCarById("C001");
        assertTrue(car.isPresent());
        assertTrue(car.get().isAvailable());
    }
}
