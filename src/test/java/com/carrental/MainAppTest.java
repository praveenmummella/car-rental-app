package com.carrental;

import com.carrental.service.CarService;
import com.carrental.service.RentalService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MainAppTest {
    @Test
    void testMainApplicationRunsWithoutErrors() {
        // This just verifies the main method runs without throwing exceptions
        assertDoesNotThrow(() -> {
            CarService carService = new CarService();
            RentalService rentalService = new RentalService(carService);
            MainApp mainApp = new MainApp();
            
            // In a real test, you might want to redirect System.out to verify output
            MainApp.main(new String[]{});
        });
    }
    
    @Test
    void testMainAppConstructor() {
        assertDoesNotThrow(() -> new MainApp());
    }
}
