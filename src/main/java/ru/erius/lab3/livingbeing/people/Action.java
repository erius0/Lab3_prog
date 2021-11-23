package ru.erius.lab3.livingbeing.people;

import ru.erius.lab3.livingbeing.LivingBeing;

@FunctionalInterface
public interface Action {
    void act(LivingBeing livingBeing);
}
