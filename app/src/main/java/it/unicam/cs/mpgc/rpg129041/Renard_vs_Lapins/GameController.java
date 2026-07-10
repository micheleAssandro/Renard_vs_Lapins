package it.unicam.cs.mpgc.rpg129041.Renard_vs_Lapins;

import java.util.concurrent.ThreadLocalRandom;

public class GameController {

    private Board board;
    private Fox fox;

    private int iterations;
    private int current = 0;

    public GameController() {
        board = new Board();

        fox = new Fox();
        board.placeEntity(fox, 0, 0);

        // tra 5 e 14
        iterations = ThreadLocalRandom.current().nextInt(5, 15);
    }

    public boolean step() {

        if (current >= iterations) return false;

        board.spawnRabbit();
        fox.makeMove(board);

        current++;
        return true;
    }

    public Result getResult(String player) {

        int R = board.getRabbitCount();
        boolean playerWon = R == 0;

        Result result = new Result(player, R, playerWon);
        JsonWriter.save(result);

        return result;
    }

    public Board getBoard() {
        return board;
    }
}