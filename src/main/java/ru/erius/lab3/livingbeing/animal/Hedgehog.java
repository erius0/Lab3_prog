package ru.erius.lab3.livingbeing.animal;

import ru.erius.lab3.livingbeing.LivingBeing;
import ru.erius.lab3.game.assets.Ball;
import ru.erius.lab3.livingbeing.people.BasicAction;

public class Hedgehog extends LivingBeing implements Ball {

    private final static float RUN_AWAY_PROBABILITY = 0.1F;

    public Hedgehog() {
        this("Ёжик");
    }

    public Hedgehog(LivingBeing livingBeing) {
        this(livingBeing.getName());
    }

    public Hedgehog(String name) {
        super(name);
    }

    @Override
    public void roll() {
        System.out.println(this.name + " покатился");
    }

    @Override
    public void speak() {
        System.out.println(this.name + " пищит");
    }

    public boolean runAway() {
        boolean ranAway = Math.random() < RUN_AWAY_PROBABILITY;
        if (ranAway) this.doSomething(BasicAction.RUN_AWAY);
        return ranAway;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Hedgehog{" +
                "name='" + name + '\'' +
                '}';
    }
}
