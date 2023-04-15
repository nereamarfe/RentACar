package org.example.controller;

import org.example.model.Car;
import org.example.service.CarServiceImpl;
import org.example.service.ICarService;

import java.util.ArrayList;

public class CarController {
    private ICarService service;

    public CarController(){
        service = new CarServiceImpl();
    }

    public void add(String lisenceplate){
        Car car = new Car(lisenceplate);
        service.add(car);

    }

    public void deleteById(Long id){
        service.deleteById(id);

    }

    public ArrayList findAll(){
        return service.findAll();
    }

    public Car findByLisencePlate(String lisenceplate){

        return service.findByLisencePlate(lisenceplate);
    }

    public void update(Long id, String lisenceplate){
        Car car = new Car(id,lisenceplate);
        service.update(car);
    }
}
