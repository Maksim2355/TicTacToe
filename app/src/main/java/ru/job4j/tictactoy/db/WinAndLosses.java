package ru.job4j.tictactoy.db;

import androidx.room.Entity;

public class WinAndLosses {

    private int win;

    private int losses;


    public WinAndLosses(int win, int losses) {
        this.win = win;
        this.losses = losses;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
