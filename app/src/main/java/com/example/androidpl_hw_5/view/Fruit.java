package com.example.androidpl_hw_5.view;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_fruits")
public class Fruit {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nameFruit;

    public String colorFruit;

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", fruit='" + nameFruit + '\'' +
                ", color='" + colorFruit + '\'' +
                '}';
    }
}
