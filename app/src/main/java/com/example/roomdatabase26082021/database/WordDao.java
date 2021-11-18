package com.example.roomdatabase26082021.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabase26082021.database.entities.WordEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

@Dao
public interface WordDao {

    @Query("SELECT * FROM word ORDER BY id DESC LIMIT ((:currentPage - 1) * :countItem) , :countItem")
    Flowable<List<WordEntity>> getListWords(int currentPage, int countItem);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Maybe<Long> insertWord(WordEntity wordEntity);

    @Query("UPDATE word SET memorized = :memorized WHERE id = :id")
    Completable update(boolean memorized, long id);

    @Query("DELETE FROM word WHERE id = :id")
    Completable delete(long id);
}
