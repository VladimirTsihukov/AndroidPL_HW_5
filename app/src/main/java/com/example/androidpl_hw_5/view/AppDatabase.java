package com.example.androidpl_hw_5.view;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Fruit.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FruitDao fruitDao();
}
