package ru.erius.lab3.pattern_observer;

import java.util.Objects;

public class Car {
    String model, type;
    boolean working;

    protected Car(String model, String type) {
        this(model, type, true);
    }

    protected Car(String model, String type, boolean working) {
        this.model = model;
        this.type = type;
        this.working = working;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return working == car.working && Objects.equals(model, car.model) && Objects.equals(type, car.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, type, working);
    }
}
