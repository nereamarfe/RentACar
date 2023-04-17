package org.example.model;

import java.time.LocalDate;

public class Rental {
    private Long id;
    private Client client;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;

    public Rental(Client client, Car car, LocalDate startDate, LocalDate endDate) {
        this.client = client;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Rental(Long id, Client client, Car car, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.client = client;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    @Override
    public String toString() {
        return id + " Client:" + client + " Car:" + car + " Start rental:" + startDate + " End rental:" + endDate;
    }
}
