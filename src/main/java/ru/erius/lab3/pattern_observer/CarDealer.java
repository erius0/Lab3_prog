package ru.erius.lab3.pattern_observer;

import ru.erius.lab3.livingbeing.people.Person;

import java.util.LinkedList;
import java.util.Queue;

public class CarDealer implements CarObserver {

    private final Queue<Car> carsToSell = new LinkedList<>();
    private String name;

    public CarDealer(String name) {
        this.name = name;
    }

    public void sellCar(Person person) {
        Car car = carsToSell.poll();
        if (car == null) {
            System.out.println(this.name + ": Нет машин для продажи :(");
            return;
        }
        System.out.println(this.name + ": " + person.getName() + " купил машину " + car.model);
    }

    @Override
    public void update(Car car) {
        this.carsToSell.add(car);
        System.out.println(this.name + ": Машина " + car.model + " готова к продаже");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Queue<Car> getCarsToSell() {
        return carsToSell;
    }
}
