package ru.erius.lab3;

import ru.erius.lab3.game.Cricket;
import ru.erius.lab3.game.assets.CricketPlayer;
import ru.erius.lab3.game.assets.Player;
import ru.erius.lab3.livingbeing.people.BasicAction;
import ru.erius.lab3.livingbeing.people.Person;
import ru.erius.lab3.livingbeing.people.Soldier;

import java.util.HashMap;
import java.util.HashSet;

public class Lab3 {
    // test
    public final static Cricket GAME = new Cricket();
    public final static Person
            ALICE = new Person("Алиса", 12),
            QUEEN = new Person("Королева", 30, "Отрубить ей голову!");
    public final static Soldier SOLDIER = new Soldier("Солдат №1");

    public static void main(String[] args) {
        Lab3.prepareCricket();
        QUEEN.doSomething(BasicAction.ENRAGE);
        SOLDIER.doSomething(BasicAction.PATROL);
    }

    public static void prepareCricket() {
        Player[] team1 = {
                new CricketPlayer(ALICE),
                new CricketPlayer("Казуя", 32, 0.3F),
                new CricketPlayer("Конор", 25, 0.6F)
        };
        Player[] team2 = {
                new CricketPlayer(QUEEN),
                new CricketPlayer("Мэдлин", 21, 0.4F),
                new CricketPlayer("Юджин", 33, 0.2F)
        };
        GAME.addToTeam1(team1);
        GAME.addToTeam2(team2);
        GAME.start();
    }

    @FunctionalInterface
    interface Func {
        void exec();
    }

    static class FuncClass {
        public void exec(Func func) {
            func.exec();
        }
    }
}
