package ru.erius.lab3.livingbeing.people;

import ru.erius.lab3.inanimate.Gates;

import java.util.Objects;

public class Soldier extends Person implements Gates {

    private boolean areClosed = false;
    private boolean isWorkingOut = false;

    public Soldier(String name) {
        this(name, 0, null);
    }

    public Soldier(Person person) {
        this(person.getName(), person.getAge(), person.getSpeech());
    }

    public Soldier(String name, int age) {
        this(name, age, null);
    }

    public Soldier(String name, int age, String speech) {
        super(name, age, speech);
    }

    @Override
    public void open() {
        System.out.println(this.name + ": Проход разрешен!");
        this.areClosed = false;
    }

    @Override
    public void close() {
        System.out.println(this.name + ": Проход запрещен!");
        this.areClosed = true;
    }

    @Override
    public boolean areClosed() {
        return this.areClosed;
    }

    public boolean isWorkingOut() {
        return this.isWorkingOut;
    }

    public void workOut() {
        System.out.println(this.name + " пошел разминаться");
        this.isWorkingOut = true;
    }

    public void stopWorkingOut() {
        System.out.println(this.name + " перестал разминаться");
        this.isWorkingOut = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Soldier soldier = (Soldier) o;
        return areClosed == soldier.areClosed && isWorkingOut == soldier.isWorkingOut;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), areClosed, isWorkingOut);
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "name='" + name + '\'' +
                ", speech='" + speech + '\'' +
                ", areClosed=" + areClosed +
                ", isWorkingOut=" + isWorkingOut +
                '}';
    }
}
