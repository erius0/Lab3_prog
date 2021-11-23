package ru.erius.lab3.livingbeing.people;

import ru.erius.lab3.livingbeing.LivingBeing;
import ru.erius.lab3.livingbeing.animal.Flamingo;

public enum BasicAction implements Action {

    LAUGH(livingBeing -> {
        if (!(livingBeing instanceof Person)) return;
        System.out.println(livingBeing.getName() + " засемялся");
    }),

    ENRAGE(livingBeing -> {
        if (!(livingBeing instanceof Person)) return;
        ((Person) livingBeing).speech = "Отрубить ей голову!";
        System.out.println(livingBeing.getName() + " в ярости");
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println();
                livingBeing.speak();
                System.out.println();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }),

    BRAWL(livingBeing -> {
        if (!(livingBeing instanceof Person)) return;
        System.out.println(livingBeing.getName() + " скандалит");
    }),

    LOOK_AT_OWNER(livingBeing -> {
        if (!(livingBeing instanceof Flamingo)) return;
        System.out.println(livingBeing.getName() + " смотрит на владельца");
    }),

    PATROL(livingBeing -> {
        if (!(livingBeing instanceof Soldier)) return;
        Soldier soldier = ((Soldier) livingBeing);
        System.out.println(livingBeing.getName() + " на службе");
        soldier.close();
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                soldier.workOut();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }),

    RUN_AWAY(livingBeing -> System.out.println(livingBeing.getName() + " убежал"));

    Action action;

    BasicAction(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }

    @Override
    public void act(LivingBeing livingBeing) {
        this.action.act(livingBeing);
    }

    @Override
    public String toString() {
        return "BasicAction{" +
                "action=" + action +
                '}';
    }
}
