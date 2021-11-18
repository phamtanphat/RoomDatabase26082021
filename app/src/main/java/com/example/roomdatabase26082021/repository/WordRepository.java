package com.example.roomdatabase26082021.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomdatabase26082021.database.WordDao;
import com.example.roomdatabase26082021.database.WordDatabase;
import com.example.roomdatabase26082021.database.entities.WordEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public class WordRepository {
    private WordDao wordDao;

    public WordRepository(Application application){
        wordDao = WordDatabase.createDatabase(application).wordDao();
    }

    public Flowable<List<WordEntity>> getListWords(){
        return wordDao.getListWords();
    }

    public Maybe<Long> insertWord(WordEntity wordEntity){
        return wordDao.insertWord(wordEntity);
    }

    public Completable updateWord(boolean memorized , long id){
        return wordDao.update(memorized,id);
    }
}
