package org.example.repository;

import org.example.model.Car;
import org.example.model.Client;
import org.example.model.Rental;

import java.util.ArrayList;
import java.util.Iterator;

public class RentalRepository implements IRentalRepository{

    private ArrayList<Rental> rentals;

    public RentalRepository() {
        this.rentals = new ArrayList<Rental>();
    }


    @Override
    public void add(Rental rental) {
        rental.setId(nextIdAvailable());
        rentals.add(rental);
    }

    @Override
    public void deleteById(Long id) {
        if(!rentals.isEmpty()) {
            Iterator<Rental> iterator = rentals.iterator();
            while (iterator.hasNext()){
                Rental rental = iterator.next();
                if (rental.getId() == id) {
                    rentals.remove(rental);
                    break;
                }
            }
        }
    }

    @Override
    public ArrayList findAll() {
        return rentals;
    }

    @Override
    public Long nextIdAvailable() {
        if(!rentals.isEmpty()){
            return rentals.get(rentals.size()-1).getId() + 1;
        }
        else{
            return (long)1;
        }

    }

    @Override
    public Rental findById(Long id) {
        if(!rentals.isEmpty()){
            for (Rental rental : rentals) {
                if(rental.getId() == id){
                    return rental;
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public void update(Rental rental) {
        Rental rentalToUpdate = findById(rental.getId());
        if(rentalToUpdate != null){
            rentalToUpdate.setClient(rental.getClient());
            rentalToUpdate.setCar(rental.getCar());
            rentalToUpdate.setStartDate(rental.getStartDate());
            rentalToUpdate.setEndDate(rental.getEndDate());
        }
    }
}
