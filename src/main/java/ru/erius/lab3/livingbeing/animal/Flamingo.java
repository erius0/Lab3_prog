package ru.erius.lab3.livingbeing.animal;

import ru.erius.lab3.livingbeing.LivingBeing;
import ru.erius.lab3.game.assets.Ball;
import ru.erius.lab3.game.assets.Bat;
import ru.erius.lab3.livingbeing.people.BasicAction;

public class Flamingo extends LivingBeing implements Bat {

    private final static float LOOK_AT_WIELDER_PROBABILITY = 0.2F;

    public Flamingo() {
        this("Фламинго");
    }

    public Flamingo(LivingBeing livingBeing) {
        this(livingBeing.getName());
    }

    public Flamingo(String name) {
        super(name);
    }

    @Override
    public boolean hitTheBall(Ball ball) {
        boolean looking = Math.random() < LOOK_AT_WIELDER_PROBABILITY;
        if (looking) this.doSomething(BasicAction.LOOK_AT_OWNER);
        else ball.roll();
        return !looking;
    }

    @Override
    public void speak() {
        System.out.println(this.name + " щебечет");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "Flamingo{" +
                "name='" + name + '\'' +
                '}';
    }
}
