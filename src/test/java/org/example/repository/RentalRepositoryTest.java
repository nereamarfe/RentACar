package org.example.repository;

import org.example.model.Car;
import org.example.model.Client;
import org.example.model.Rental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RentalRepositoryTest {

    RentalRepository repository;

    @BeforeEach
    void setUp() {
        repository = new RentalRepository();
        Client client1 = new Client("35578855V","Sara","Perez");
        Car car1 = new Car("1234ABC");
        LocalDate start1 = LocalDate.of(2023,4,15);
        LocalDate end1 = LocalDate.of(2023,5,1);
        Rental rental1 = new Rental(client1,car1,start1,end1);
        repository.add(rental1);
    }

    @Test
    void add() {
        Client client2 = new Client("1111111L","Manu","Garcia");
        Car car2 = new Car("9876GHT");
        LocalDate start2 = LocalDate.of(2023,2,2);
        LocalDate end2 = LocalDate.of(2023,2,5);
        Rental rental2 = new Rental(client2,car2,start2,end2);
        repository.add(rental2);
        Assertions.assertEquals(rental2.getId(),repository.findById(2L).getId());


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
    }

    @Test
    void update() {
    }
}