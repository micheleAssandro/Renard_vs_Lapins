package it.unicam.cs.mpgc.rpg129041.Renard_vs_Lapins;

public class Fox extends Entity {

    public Fox() {
        super(EntityType.FOX);
    }

    public void makeMove(Board board) {

        for (int attempt = 0; attempt < 20; attempt++) {

            MoveType move = MoveType.random();
            int[] next = move.generate(row, col, board);

            if (next == null) continue;

            int newR = next[0];
            int newC = next[1];

            if (board.isRabbit(newR, newC)) {
                board.removeRabbit(newR, newC);
                System.out.println("Rabbit Catturato!");
            }

            board.moveEntity(this, newR, newC);
            return;
        }
    }
}
