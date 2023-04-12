package org.example.model;

public class Car {
    private Long id;
    private String lisencePlate;

    public Car(String lisencePlate) {
        this.lisencePlate = lisencePlate;
    }

    public Car(Long id, String lisencePlate) {
        this.id = id;
        this.lisencePlate = lisencePlate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLisencePlate() {
        return lisencePlate;
    }

    public void setLisencePlate(String lisencePlate) {
        this.lisencePlate = lisencePlate;
    }

    @Override
    public String toString() {
        return id + " " + lisencePlate;
    }
}
