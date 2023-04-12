package org.example.repository;

import org.example.model.Car;

import java.util.ArrayList;

public interface ICarRepository {

    void add(Car car);
    void deleteById(Long id);
    ArrayList findAll();
    public Long nextIdAvailable();
    Car findById(Long id);
    Car findByLisencePlate(String lisencePlate);
    void update(Car car);


}
