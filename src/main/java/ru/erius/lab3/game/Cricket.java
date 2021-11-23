package ru.erius.lab3.game;

import ru.erius.lab3.game.assets.Ball;
import ru.erius.lab3.game.assets.Player;
import ru.erius.lab3.livingbeing.animal.Hedgehog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cricket implements Game{

    private final static int BALLS_AMOUNT = 6;
    private final List<Ball> BALLS = new ArrayList<>();
    private final List<Player> TEAM1 = new ArrayList<>();
    private final List<Player> TEAM2 = new ArrayList<>();
    private boolean gameInProgress = false;

    {
        this.reset();
    }

    public Cricket() {

    }

    public Cricket(List<Player> team1, List<Player> team2) {
        this.addToTeam1(team1);
        this.addToTeam2(team2);
    }

    public Cricket(Player[] team1, Player[] team2) {
        this.addToTeam1(team1);
        this.addToTeam2(team2);
    }

    public void addToTeam1(Player... players) {
        this.addToTeam1(Arrays.asList(players));
    }

    public void addToTeam1(List<Player> players) {
        TEAM1.addAll(players);
    }

    public void addToTeam2(Player... players) {
        this.addToTeam2(Arrays.asList(players));
    }

    public void addToTeam2(List<Player> players) {
        TEAM2.addAll(players);
    }

    private void reset() {
        this.gameInProgress = false;
        for (int i = 1; i < BALLS_AMOUNT + 1; i++) BALLS.add(new Hedgehog("Шар №" + i));
        TEAM1.forEach(player -> player.setScore(0));
        TEAM2.forEach(player -> player.setScore(0));
    }

    @Override
    public void start() {
        this.gameInProgress = true;
        if (TEAM1.size() < 1 || TEAM2.size() < 1)
            throw new IllegalArgumentException("В кождой команде должно быть как минимум по 1 игроку");
        new Thread(() -> {
            while (this.isGameInProgress()) {
                List<Player> allPlayers = Stream.concat(TEAM1.stream(), TEAM2.stream()).collect(Collectors.toList());
                int playerIndex = (int) (Math.random() * allPlayers.size());
                int ballIndex = (int) (Math.random() * BALLS.size());
                Player player = allPlayers.get(playerIndex);
                Ball ball = BALLS.get(ballIndex);
                boolean success = player.makeAMove(ball);
                System.out.println();
                if (success) BALLS.remove(ballIndex);
                try {
                    Thread.sleep(1500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (BALLS.size() == 0) this.gameInProgress = false;
            }
            this.end();
        }).start();
    }

    @Override
    public void end() {
        System.out.println("Игра окончена!");
        int team1Score = TEAM1.stream().mapToInt(Player::getScore).sum();
        int team2Score = TEAM2.stream().mapToInt(Player::getScore).sum();
        System.out.println("Первая команда - " + team1Score + ", вторая команда - " + team2Score);
        if (team1Score > team2Score) System.out.println("Победила первая команда!");
        else if (team1Score < team2Score) System.out.println("Победила вторая команда!");
        else System.out.println("Ничья!");
        this.reset();
    }

    public List<Ball> getBalls() {
        return BALLS;
    }

    public List<Player> getTeam1() {
        return TEAM1;
    }

    public List<Player> getTeam2() {
        return TEAM2;
    }

    public boolean isGameInProgress() {
        return gameInProgress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cricket cricket = (Cricket) o;
        return gameInProgress == cricket.gameInProgress && Objects.equals(BALLS, cricket.BALLS) && Objects.equals(TEAM1, cricket.TEAM1) && Objects.equals(TEAM2, cricket.TEAM2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(BALLS, TEAM1, TEAM2, gameInProgress);
    }

    @Override
    public String toString() {
        return "Cricket{" +
                "BALLS=" + BALLS +
                ", TEAM1=" + TEAM1 +
                ", TEAM2=" + TEAM2 +
                ", gameInProgress=" + gameInProgress +
                '}';
    }
}
