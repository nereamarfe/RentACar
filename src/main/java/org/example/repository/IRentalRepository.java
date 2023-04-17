package org.example.repository;

import org.example.model.Car;
import org.example.model.Rental;

import java.util.ArrayList;

public interface IRentalRepository {

    void add(Rental rental);
    void deleteById(Long id);
    ArrayList findAll();
    public Long nextIdAvailable();
    Rental findById(Long id);
    void update(Rental rental);
}
