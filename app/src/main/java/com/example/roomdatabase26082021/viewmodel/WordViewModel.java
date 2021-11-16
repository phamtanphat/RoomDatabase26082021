package com.example.roomdatabase26082021.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase26082021.database.entities.WordEntity;
import com.example.roomdatabase26082021.repository.WordRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WordViewModel extends AndroidViewModel {
    private MutableLiveData<List<WordEntity>> lstWords = new MutableLiveData<>();
    private MutableLiveData<Throwable> error = new MutableLiveData<>();
    private WordRepository wordRepository;
    private CompositeDisposable compositeDisposable;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
        compositeDisposable = new CompositeDisposable();
    }

    public LiveData<List<WordEntity>> getWords(){
        return lstWords;
    }
    public void queryListWords(){
        wordRepository.getListWords()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable()
                .subscribe(new Observer<List<WordEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(@NonNull List<WordEntity> wordEntities) {
                        lstWords.setValue(wordEntities);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        error.setValue(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
