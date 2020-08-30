package com.example.androidpl_hw_5.view;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface FruitDao {

    @Query("SELECT * FROM table_fruits")
    Single<List<Fruit>> getAll();

    @Query("SELECT * FROM table_fruits WHERE id = :id")
    Single<Fruit> getAllById(int id);

    @Insert
    Single<Long> insert(Fruit fruit);

    @Insert
    Single<List<Long>> insertList(List<Fruit> fruits);

    @Delete
    Single<Integer> delete(Fruit fruit);

    @Query("DELETE FROM table_fruits WHERE nameFruit = :nameFruit")
    Single<Integer> deleteForName(String nameFruit);

    @Update
    Single<Integer> update(Fruit fruit);
}
