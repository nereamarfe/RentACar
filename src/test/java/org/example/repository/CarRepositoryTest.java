package org.example.repository;

import org.example.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    CarRepository repository;

    @BeforeEach
    void setUp() {
        repository = new CarRepository();
        Car car1 = new Car("BWL");
        repository.add(car1);
    }

    @Test
    void add() {
        Car car2 = new Car("BWV");
        repository.add(car2);
        Assertions.assertEquals(car2,repository.findById(2L));
    }

    @Test
    void deleteById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void nextIdAvailable() {
    }

    @Test
    void findById() {
        Assertions.assertEquals("BWL",repository.findById(1L).getLisencePlate());
    }

    @Test
    void findByDni() {
    }

    @Test
    void update() {
    }
}