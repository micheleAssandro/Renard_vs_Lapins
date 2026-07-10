package it.unicam.cs.mpgc.rpg129041.Renard_vs_Lapins;

public abstract class Entity {

    protected int row, col;
    protected EntityType type;

    public Entity(EntityType type) {
        this.type = type;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    public void setPosition(int r, int c) {
        this.row = r;
        this.col = c;
    }

    public EntityType getType() {
        return type;
    }
}