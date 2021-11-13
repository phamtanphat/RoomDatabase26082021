package com.example.roomdatabase26082021.database;

import androidx.room.Database;

import com.example.roomdatabase26082021.database.entities.WordEntity;

@Database(entities = {WordEntity.class} , version = 1)
public abstract class WordDatabase {
}
