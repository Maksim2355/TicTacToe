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

    //количнство игроков, которые приняли участие
    @ColumnInfo(name = "numbers_player")
    private int numbersPlayers;

    //Число партий первого игрока
    @ColumnInfo(name = "numbers_parties_player")
    private int numbersPartiesPlayer;

    //Число партий первого игрока
    @ColumnInfo(name = "numbers_parties_win_and_lose_player")
    @Embedded
    private WinAndLosses numbersWinAndLosePartiesPlayer;

    //Число партий второго игрока
    @ColumnInfo(name = "numbers_parties_second_player")
    private int numbersPartiesSecondPlayer;

    //Число партий второго игрока
    @ColumnInfo(name = "numbers_parties_win_and_lose_second_player")
    @Embedded
    private WinAndLosses numbersWinAndLosePartiesSecondPlayer;

    //Число партий компьютера
    @ColumnInfo(name = "numbers_parties_computer")
    private int numbersPartiesComputer;

    //Число партий компьютера
    @ColumnInfo(name = "numbers_parties_win_and_lose_computer")
    @Embedded
    private WinAndLosses numbersWinAndLosePartiesComputer;

    //Среднее время партии
    @ColumnInfo(name = "average_bath_time")
    private int averageBathTime;

    public StatisticDb(long id, int numbersPlayers, int numbersPartiesPlayer, WinAndLosses numbersWinAndLosePartiesPlayer, int numbersPartiesSecondPlayer, WinAndLosses numbersWinAndLosePartiesSecondPlayer, int numbersPartiesComputer, WinAndLosses numbersWinAndLosePartiesComputer, int averageBathTime) {
        this.id = id;
        this.numbersPlayers = numbersPlayers;
        this.numbersPartiesPlayer = numbersPartiesPlayer;
        this.numbersWinAndLosePartiesPlayer = numbersWinAndLosePartiesPlayer;
        this.numbersPartiesSecondPlayer = numbersPartiesSecondPlayer;
        this.numbersWinAndLosePartiesSecondPlayer = numbersWinAndLosePartiesSecondPlayer;
        this.numbersPartiesComputer = numbersPartiesComputer;
        this.numbersWinAndLosePartiesComputer = numbersWinAndLosePartiesComputer;
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

    public WinAndLosses getNumbersWinAndLosePartiesPlayer() {
        return numbersWinAndLosePartiesPlayer;
    }

    public void setNumbersWinAndLosePartiesPlayer(WinAndLosses numbersWinAndLosePartiesPlayer) {
        this.numbersWinAndLosePartiesPlayer = numbersWinAndLosePartiesPlayer;
    }

    public int getNumbersPartiesSecondPlayer() {
        return numbersPartiesSecondPlayer;
    }

    public void setNumbersPartiesSecondPlayer(int numbersPartiesSecondPlayer) {
        this.numbersPartiesSecondPlayer = numbersPartiesSecondPlayer;
    }

    public WinAndLosses getNumbersWinAndLosePartiesSecondPlayer() {
        return numbersWinAndLosePartiesSecondPlayer;
    }

    public void setNumbersWinAndLosePartiesSecondPlayer(WinAndLosses numbersWinAndLosePartiesSecondPlayer) {
        this.numbersWinAndLosePartiesSecondPlayer = numbersWinAndLosePartiesSecondPlayer;
    }

    public int getNumbersPartiesComputer() {
        return numbersPartiesComputer;
    }

    public void setNumbersPartiesComputer(int numbersPartiesComputer) {
        this.numbersPartiesComputer = numbersPartiesComputer;
    }

    public WinAndLosses getNumbersWinAndLosePartiesComputer() {
        return numbersWinAndLosePartiesComputer;
    }

    public void setNumbersWinAndLosePartiesComputer(WinAndLosses numbersWinAndLosePartiesComputer) {
        this.numbersWinAndLosePartiesComputer = numbersWinAndLosePartiesComputer;
    }

    public int getAverageBathTime() {
        return averageBathTime;
    }

    public void setAverageBathTime(int averageBathTime) {
        this.averageBathTime = averageBathTime;
    }
}
