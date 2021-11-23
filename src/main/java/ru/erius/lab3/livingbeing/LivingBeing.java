package ru.erius.lab3.livingbeing;

import ru.erius.lab3.livingbeing.people.Action;

import java.util.Objects;

public abstract class LivingBeing {

    protected String name;
    protected int age;

    protected LivingBeing(String name) {
        this(name, 0);
    }

    protected LivingBeing(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void speak();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void doSomething(Action action) {
        action.act(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivingBeing that = (LivingBeing) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "LivingBeing{" +
                "name='" + name + '\'' +
                '}';
    }
}
