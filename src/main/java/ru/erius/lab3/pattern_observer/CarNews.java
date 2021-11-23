package ru.erius.lab3.pattern_observer;

import java.util.HashSet;
import java.util.Set;

public class CarNews implements CarObserver {

    private String name;
    private final Set<Car> uniqueCars = new HashSet<>();

    public CarNews(String name) {
        this.name = name;
    }

    @Override
    public void update(Car car) {
        boolean isCarNew = uniqueCars.add(car);
        if (isCarNew) System.out.println(this.name + ": Сделана новая машина " + car.model + " " + car.type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Car> getUniqueCars() {
        return uniqueCars;
    }
}
