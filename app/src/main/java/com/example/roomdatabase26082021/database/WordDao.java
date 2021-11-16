package com.example.roomdatabase26082021.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.roomdatabase26082021.database.entities.WordEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface WordDao {

    @Query("Select * from word")
    Flowable<List<WordEntity>> getListWords();
}
