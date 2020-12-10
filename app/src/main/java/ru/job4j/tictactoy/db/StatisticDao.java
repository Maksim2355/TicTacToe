package ru.job4j.tictactoy.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StatisticDao {

    @Query("SELECT * FROM statisticdb")
    List<StatisticDb> getStatistic();

    @Insert
    void addStatistic(StatisticDb statisticDb);

    @Update
    void updateNumbersPlayers(StatisticDb statisticDb);

    @Update
    void updateNumbersPartiesPlayer(StatisticDb statisticDb);

    @Update
    void updateNumbersPartiesSecondPlayer(StatisticDb statisticDb);

    @Update
    void updateNumbersPartiesComputer(StatisticDb statisticDb);

    @Update
    void updateAverageBathTime(StatisticDb statisticDb);

}
