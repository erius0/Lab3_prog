package ru.erius.lab3.pattern_observer;

import java.util.ArrayList;
import java.util.List;

public class CarFactory{

    private String name;
    private final List<CarObserver> observers = new ArrayList<>();

    public CarFactory(String name, CarObserver observer) {
        this.name = name;
        this.observers.add(observer);
    }

    public void makeCar(String model, String type) {
        Car car = new Car(model, type);
        System.out.println(this.name + ": Сделана машина " + model);
        observers.forEach(observer -> observer.update(car));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CarObserver> getObservers() {
        return this.observers;
    }

    public void addObserver(CarObserver observer) {
        this.observers.add(observer);
    }
}
