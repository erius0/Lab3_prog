package ru.erius.lab3.game.assets;

public interface Player {
    boolean makeAMove(Ball ball);
    int getScore();
    void setScore(int score);
}
