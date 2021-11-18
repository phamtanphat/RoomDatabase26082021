package com.example.roomdatabase26082021.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.roomdatabase26082021.R;
import com.example.roomdatabase26082021.database.entities.WordEntity;
import com.example.roomdatabase26082021.viewmodel.WordViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    WordViewModel mWordViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWordViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(WordViewModel.class);

        mWordViewModel.getWords().observe(this, new Observer<List<WordEntity>>() {
            @Override
            public void onChanged(List<WordEntity> wordEntities) {
                Log.d("BBB",wordEntities.toString() + "");
            }
        });

//        mWordViewModel.getIdInsert().observe(this, new Observer<Long>() {
//            @Override
//            public void onChanged(Long aLong) {
//                Log.d("BBB","Id insert " + aLong);
//            }
//        });

        mWordViewModel.queryListWords();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mWordViewModel.insertWord(new WordEntity("Four","Bốn"));
//            }
//        },2000);

        mWordViewModel.updateWord(true,20);
    }
}