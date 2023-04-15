package org.example.service;

import org.example.model.Car;
import org.example.repository.CarRepository;
import org.example.repository.ICarRepository;

import java.util.ArrayList;

public class CarServiceImpl implements ICarService {

    private ICarRepository repository;

    public CarServiceImpl(){
        repository = new CarRepository();
    }

    @Override
    public void add(Car car) {
        repository.add(car);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ArrayList findAll() {
        return repository.findAll();
    }

    @Override
    public Car findByLisencePlate(String lisenseplate) {
        return repository.findByLisencePlate(lisenseplate);
    }

    @Override
    public void update(Car car) {
        repository.update(car);
    }
}
