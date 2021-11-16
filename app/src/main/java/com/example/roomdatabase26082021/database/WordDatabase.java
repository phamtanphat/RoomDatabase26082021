package com.example.roomdatabase26082021.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.roomdatabase26082021.database.entities.WordEntity;

@Database(entities = {WordEntity.class}, version = 1 )
public abstract class WordDatabase extends RoomDatabase {
    private static WordDatabase wordDatabase = null;

    public abstract WordDao wordDao();

    public synchronized static WordDatabase createDatabase(Application application){
        if (wordDatabase == null){
            wordDatabase = Room.databaseBuilder(
                    application,
                    WordDatabase.class,
                    "worddb"
            )
                    .build();
        }
        return wordDatabase;
    }
}
