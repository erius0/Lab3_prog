package ru.erius.lab3.game.assets;

import ru.erius.lab3.livingbeing.animal.Flamingo;
import ru.erius.lab3.livingbeing.animal.Hedgehog;
import ru.erius.lab3.livingbeing.people.BasicAction;
import ru.erius.lab3.livingbeing.people.Person;

import java.util.Objects;

public class CricketPlayer extends Person implements Player {

    private final Bat bat = new Flamingo();
    private int score = 0;
    private final float skill;

    public CricketPlayer(String name) {
        this(name, 0, null, 0.5F);
    }

    public CricketPlayer(Person person) {
        this(person.getName(), person.getAge(), person.getSpeech(), 0.5F);
    }

    public CricketPlayer(String name, int age, float skill) {
        this(name, age, null, skill);
    }

    public CricketPlayer(String name, int age, String speech, float skill) {
        super(name, age, speech);
        this.skill = skill;
    }

    @Override
    public boolean makeAMove(Ball ball) {
        boolean prepared = this.prepare(ball);
        if (!prepared) return false;
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean hit = this.bat.hitTheBall(ball);
        if (!hit) {
            this.doSomething(BasicAction.LAUGH);
            return false;
        }
        boolean success = Math.random() < this.skill;
        String msg = success ? "Точно в цель! Очки игрока: " + ++score : "Не повезло! Очки игрока: " + score;
        System.out.println(msg);
        return success;
    }

    private boolean prepare(Ball ball) {
        System.out.println("Игрок " + this.name + " готовится к удару");
        if (this.bat instanceof Flamingo) System.out.println("Игрок " + this.name + " выпрямляет шею фламинго");
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ball instanceof Hedgehog) {
            boolean ranAway = ((Hedgehog) ball).runAway();
            if (ranAway) this.doSomething(BasicAction.BRAWL);
            return !ranAway;
        }
        return true;
    }

    public Bat getBat() {
        return bat;
    }

    public float getSkill() {
        return skill;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CricketPlayer that = (CricketPlayer) o;
        return score == that.score && Float.compare(that.skill, skill) == 0 && Objects.equals(bat, that.bat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bat, score, skill);
    }


    @Override
    public String toString() {
        return "CricketPlayer{" +
                "bat=" + bat +
                ", score=" + score +
                ", skill=" + skill +
                ", name='" + name + '\'' +
                ", speech='" + speech + '\'' +
                '}';
    }
}
