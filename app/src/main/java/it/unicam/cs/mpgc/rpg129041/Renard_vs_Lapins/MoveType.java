package it.unicam.cs.mpgc.rpg129041.Renard_vs_Lapins;

import java.util.concurrent.ThreadLocalRandom;

public enum MoveType {

    KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN;

    public static MoveType random() {
        return values()[ThreadLocalRandom.current().nextInt(values().length)];
    }

    public int[] generate(int r, int c, Board board) {

        int newR = r, newC = c;
        ThreadLocalRandom rand = ThreadLocalRandom.current();

        switch (this) {

            case KING -> {
                int[][] dirs = {
                        {1,0},{-1,0},{0,1},{0,-1},
                        {1,1},{-1,-1},{1,-1},{-1,1}
                };
                int[] d = dirs[rand.nextInt(dirs.length)];
                newR += d[0];
                newC += d[1];
            }

            case KNIGHT -> {
                int[][] moves = {
                        {2,1},{2,-1},{-2,1},{-2,-1},
                        {1,2},{1,-2},{-1,2},{-1,-2}
                };
                int[] m = moves[rand.nextInt(moves.length)];
                newR += m[0];
                newC += m[1];
            }

            case ROOK -> {
                if (rand.nextBoolean()) newR += rand.nextInt(-4, 5);
                else newC += rand.nextInt(-4, 5);
            }

            case BISHOP -> {
                int d = rand.nextInt(4);
                int step = rand.nextInt(-4, 5);

                switch (d) {
                    case 0 -> { newR += step; newC += step; }
                    case 1 -> { newR -= step; newC -= step; }
                    case 2 -> { newR += step; newC -= step; }
                    case 3 -> { newR -= step; newC += step; }
                }
            }

            case QUEEN -> {
                newR += rand.nextInt(-4, 5);
                newC += rand.nextInt(-4, 5);
            }

            case PAWN -> newR -= 1;
        }

        return board.isInside(newR, newC) ? new int[]{newR, newC} : null;
    }
}