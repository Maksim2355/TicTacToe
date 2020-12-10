package ru.job4j.tictactoy.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {StatisticDb.class}, version = 1)
public abstract class StatisticDatabase extends RoomDatabase {
    public abstract StatisticDao getStatisticDao();
}
