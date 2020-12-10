package ru.job4j.tictactoy.db;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StatisticDb {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long id;

    @ColumnInfo(name = "numbers_player")
    private int numbersPlayers;

    @ColumnInfo(name = "numbers_parties_player")
    private int numbersPartiesPlayer;

    @ColumnInfo(name = "numbers_parties_second_player")
    private int numbersPartiesSecondPlayer;

    @ColumnInfo(name = "numbers_parties_computer")
    private int numbersPartiesComputer;

    @ColumnInfo(name = "numbers_win_player")
    private int numbersWinPartiesPlayer;

    @ColumnInfo(name = "numbers_lose_player")
    private int numbersLosePartiesPlayer;

    @ColumnInfo(name = "numbers_win_second_player")
    private int numbersWinPartiesSecondPlayer;

    @ColumnInfo(name = "numbers_lose_second_player")
    private int numbersLosePartiesSecondPlayer;

    @ColumnInfo(name = "numbers_win_computer")
    private int numbersWinPartiesComputer;

    @ColumnInfo(name = "numbers_lose_computer")
    private int numbersLosePartiesComputer;

    @ColumnInfo(name = "average_bath_time")
    private int averageBathTime;


    public StatisticDb(long id, int numbersPlayers, int numbersPartiesPlayer, int numbersPartiesSecondPlayer, int numbersPartiesComputer, int numbersWinPartiesPlayer, int numbersLosePartiesPlayer, int numbersWinPartiesSecondPlayer, int numbersLosePartiesSecondPlayer, int numbersWinPartiesComputer, int numbersLosePartiesComputer, int averageBathTime) {
        this.id = id;
        this.numbersPlayers = numbersPlayers;
        this.numbersPartiesPlayer = numbersPartiesPlayer;
        this.numbersPartiesSecondPlayer = numbersPartiesSecondPlayer;
        this.numbersPartiesComputer = numbersPartiesComputer;
        this.numbersWinPartiesPlayer = numbersWinPartiesPlayer;
        this.numbersLosePartiesPlayer = numbersLosePartiesPlayer;
        this.numbersWinPartiesSecondPlayer = numbersWinPartiesSecondPlayer;
        this.numbersLosePartiesSecondPlayer = numbersLosePartiesSecondPlayer;
        this.numbersWinPartiesComputer = numbersWinPartiesComputer;
        this.numbersLosePartiesComputer = numbersLosePartiesComputer;
        this.averageBathTime = averageBathTime;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumbersPlayers() {
        return numbersPlayers;
    }

    public void setNumbersPlayers(int numbersPlayers) {
        this.numbersPlayers = numbersPlayers;
    }

    public int getNumbersPartiesPlayer() {
        return numbersPartiesPlayer;
    }

    public void setNumbersPartiesPlayer(int numbersPartiesPlayer) {
        this.numbersPartiesPlayer = numbersPartiesPlayer;
    }

    public int getNumbersPartiesSecondPlayer() {
        return numbersPartiesSecondPlayer;
    }

    public void setNumbersPartiesSecondPlayer(int numbersPartiesSecondPlayer) {
        this.numbersPartiesSecondPlayer = numbersPartiesSecondPlayer;
    }

    public int getNumbersPartiesComputer() {
        return numbersPartiesComputer;
    }

    public void setNumbersPartiesComputer(int numbersPartiesComputer) {
        this.numbersPartiesComputer = numbersPartiesComputer;
    }

    public int getNumbersWinPartiesPlayer() {
        return numbersWinPartiesPlayer;
    }

    public void setNumbersWinPartiesPlayer(int numbersWinPartiesPlayer) {
        this.numbersWinPartiesPlayer = numbersWinPartiesPlayer;
    }

    public int getNumbersLosePartiesPlayer() {
        return numbersLosePartiesPlayer;
    }

    public void setNumbersLosePartiesPlayer(int numbersLosePartiesPlayer) {
        this.numbersLosePartiesPlayer = numbersLosePartiesPlayer;
    }

    public int getNumbersWinPartiesSecondPlayer() {
        return numbersWinPartiesSecondPlayer;
    }

    public void setNumbersWinPartiesSecondPlayer(int numbersWinPartiesSecondPlayer) {
        this.numbersWinPartiesSecondPlayer = numbersWinPartiesSecondPlayer;
    }

    public int getNumbersLosePartiesSecondPlayer() {
        return numbersLosePartiesSecondPlayer;
    }

    public void setNumbersLosePartiesSecondPlayer(int numbersLosePartiesSecondPlayer) {
        this.numbersLosePartiesSecondPlayer = numbersLosePartiesSecondPlayer;
    }

    public int getNumbersWinPartiesComputer() {
        return numbersWinPartiesComputer;
    }

    public void setNumbersWinPartiesComputer(int numbersWinPartiesComputer) {
        this.numbersWinPartiesComputer = numbersWinPartiesComputer;
    }

    public int getNumbersLosePartiesComputer() {
        return numbersLosePartiesComputer;
    }

    public void setNumbersLosePartiesComputer(int numbersLosePartiesComputer) {
        this.numbersLosePartiesComputer = numbersLosePartiesComputer;
    }

    public int getAverageBathTime() {
        return averageBathTime;
    }

    public void setAverageBathTime(int averageBathTime) {
        this.averageBathTime = averageBathTime;
    }
}
