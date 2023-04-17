package org.example.repository;

import org.example.model.Car;
import org.example.model.Client;

import java.util.ArrayList;
import java.util.Iterator;

public class CarRepository implements ICarRepository{

    private ArrayList<Car> cars;
    public CarRepository(){ cars = new ArrayList<>();}

    @Override
    public void add(Car car) {
        car.setId(nextIdAvailable());
        cars.add(car);
    }

    @Override
    public void deleteById(Long id) {
        if(!cars.isEmpty()) {
            Iterator<Car> iterator = cars.iterator();
            while (iterator.hasNext()){
                Car car = iterator.next();
                if (car.getId() == id) {
                    cars.remove(car);
                    break;
                }
            }
        }
    }

    @Override
    public ArrayList findAll() {
        return cars;
    }

    @Override
    public Long nextIdAvailable() {
        if(!cars.isEmpty()){
            return cars.get(cars.size()-1).getId() + 1;
        }
        else{
            return (long)1;
        }
    }

    @Override
    public Car findById(Long id) {
        if(!cars.isEmpty()){
            for (Car car : cars) {
                if(car.getId() == id){
                    return car;
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public Car findByLisencePlate(String lisencePlate) {
        if(!cars.isEmpty()){
            for (Car car : cars) {
                if(car.getLisencePlate().equals(lisencePlate)){
                    return car;
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public void update(Car car) {
        Car carToUpdate = findById(car.getId());
        if(carToUpdate != null){
            carToUpdate.setLisencePlate(car.getLisencePlate());
        }
    }


}
