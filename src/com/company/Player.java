package com.company;

public class Player {

    private String playerName;
    private int wins, losses, ties = 0;

    public Player(String name) {
        this.playerName = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTies() {
        return ties;
    }

    public float getWinLoss() {

        if(losses == 0) {
            return (float) wins;
        }

        else {
            return (float) wins / (float) losses;
        }

    }

    public void incrementWins(){
        this.wins++;
    }

    public void incrementLosses(){
        this.losses++;
    }

    public void incrimentTies(){
        this.ties++;
    }

}
