package org.example.repository;

import org.example.model.Car;
import org.example.model.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    CarRepository repository;

    @BeforeEach
    void setUp() {
        repository = new CarRepository();
        Car car1 = new Car("1254BWV");
        Car car2 = new Car("9875HJK");
        repository.add(car1);
        repository.add(car2);
    }

    @Test
    void add() {
        Car car3 = new Car("2587JHG");
        repository.add(car3);
        Assertions.assertEquals(car3, repository.findById(3L));
        Car car4 = new Car("6587KLM");
        repository.add(car4);
        Assertions.assertEquals(car4.getLisencePlate(), repository.findById(4L).getLisencePlate());
    }

    @Test
    void deleteById() {
        Assertions.assertEquals(2,repository.findAll().size());
        repository.deleteById(2L);
        Assertions.assertEquals(1,repository.findAll().size());
        repository.deleteById(1L);
        Assertions.assertEquals(0,repository.findAll().size());
    }

    @Test
    void findAll() {
        Assertions.assertEquals(2, repository.findAll().size());
        Car car = new Car("6547BNG");
        repository.add(car);
        Assertions.assertEquals(3, repository.findAll().size());
    }

    @Test
    void nextIdAvailable() {
        Assertions.assertEquals(3, repository.nextIdAvailable());
        Car car = new Car("5412FDS");
        repository.add(car);
        Assertions.assertEquals(4, repository.nextIdAvailable());
        repository.deleteById(1L);
        Assertions.assertEquals(4, repository.nextIdAvailable());
    }

    @Test
    void findById() {
        Assertions.assertEquals("1254BWV", repository.findById(1L).getLisencePlate());
    }

    @Test
    void findByLisencePlate() {
        Assertions.assertEquals(1L,repository.findByLisencePlate("1254BWV").getId());
    }

    @Test
    void update() {
        Assertions.assertEquals("1254BWV", repository.findById(1L).getLisencePlate());
        Car car = new Car(1L,"4521KLN");
        repository.update(car);
        Assertions.assertEquals("4521KLN",repository.findById(1L).getLisencePlate());
    }

    @Test
    void isEmpty() {
        Assertions.assertEquals(false,repository.findAll().isEmpty());
        repository.deleteById(1L);
        repository.deleteById(2L);
        Assertions.assertEquals(true,repository.findAll().isEmpty());
    }
}