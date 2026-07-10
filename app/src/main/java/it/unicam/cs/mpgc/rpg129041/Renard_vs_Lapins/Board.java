package it.unicam.cs.mpgc.rpg129041.Renard_vs_Lapins;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    public static final int SIZE = 8;

    private Entity[][] grid;
    private int rabbitCount = 0;

    public Board() {
        grid = new Entity[SIZE][SIZE];
    }

    public boolean isInside(int r, int c) {
        return r >= 0 && c >= 0 && r < SIZE && c < SIZE;
    }

    public boolean isEmpty(int r, int c) {
        return grid[r][c] == null;
    }

    public boolean isRabbit(int r, int c) {
        return grid[r][c] != null &&
                grid[r][c].getType() == EntityType.RABBIT;
    }

    public void placeEntity(Entity e, int r, int c) {
        grid[r][c] = e;
        e.setPosition(r, c);

        if (e.getType() == EntityType.RABBIT) {
            rabbitCount++;
        }
    }

    public void moveEntity(Entity e, int newR, int newC) {
        grid[e.getRow()][e.getCol()] = null;
        grid[newR][newC] = e;
        e.setPosition(newR, newC);
    }

    public void removeRabbit(int r, int c) {
        grid[r][c] = null;
        rabbitCount--;
    }

    public void spawnRabbit() {

        int r, c;

        do {
            r = ThreadLocalRandom.current().nextInt(0, SIZE);
            c = ThreadLocalRandom.current().nextInt(0, SIZE);
        } while (!isEmpty(r, c));

        placeEntity(new Rabbit(), r, c);
    }

    public int getRabbitCount() {
        return rabbitCount;
    }

    public Entity get(int r, int c) {
        return grid[r][c];
    }

    public Entity[][] getGrid() {
        return grid;
    }
}