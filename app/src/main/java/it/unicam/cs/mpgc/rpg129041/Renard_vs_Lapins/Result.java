package it.unicam.cs.mpgc.rpg129041.Renard_vs_Lapins;


public class Result {
    public String playerName;
    public int noOfRabbitSurvived;
    public String winner;

    public Result(String playerName, int r, boolean playerWon) {
        this.playerName = playerName;
        this.noOfRabbitSurvived = r;
        this.winner = playerWon ? "yes" : "no";
    }
}