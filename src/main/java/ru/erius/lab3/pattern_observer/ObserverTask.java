package ru.erius.lab3.pattern_observer;

import ru.erius.lab3.livingbeing.people.Person;

public class ObserverTask {
    public static void main(String[] args) {
        CarDealer carDealer = new CarDealer("Диллер");
        CarNews carNews = new CarNews("Новости");
        CarFactory carFactory = new CarFactory("Завод", carDealer);
        carFactory.addObserver(carNews);
        Person person = new Person("Валера");
        carFactory.makeCar("Ауди", "Универсал");
        carFactory.makeCar("Опель", "Внедорожник");
        carDealer.sellCar(person);
        carDealer.sellCar(person);
        carDealer.sellCar(person);
        carFactory.makeCar("Рено", "Минивэн");
        carDealer.sellCar(person);
        carFactory.makeCar("Опель", "Внедорожник");
        carDealer.sellCar(person);
    }
}
