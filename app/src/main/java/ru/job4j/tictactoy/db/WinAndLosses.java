package ru.job4j.tictactoy.db;

public class WinAndLosses {

    private int Win;

    private int Losses;

    public WinAndLosses(int win, int losses) {
        Win = win;
        Losses = losses;
    }

    public int getWin() {
        return Win;
    }

    public void setWin(int win) {
        Win = win;
    }

    public int getLosses() {
        return Losses;
    }

    public void setLosses(int losses) {
        Losses = losses;
    }
}
