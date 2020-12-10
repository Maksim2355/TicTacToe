package ru.job4j.tictactoy;

import android.app.Application;

import androidx.room.Room;

import ru.job4j.tictactoy.db.StatisticDatabase;

public class App extends Application {

    public static App instance;

    private StatisticDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, StatisticDatabase.class, "database")
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public StatisticDatabase getDatabase() {
        return database;
    }

}
