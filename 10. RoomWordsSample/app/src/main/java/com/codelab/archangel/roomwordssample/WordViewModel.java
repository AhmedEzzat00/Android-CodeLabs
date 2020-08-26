package com.codelab.archangel.roomwordssample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/*
    Warning:
        Never pass context into ViewModel instances.
        Do not store Activity, Fragment, or View instances or their Context in the ViewModel.

        An Activity can be destroyed and created many times during the lifecycle of a ViewModel,
        such as when the device is rotated.
        If you store a reference to the Activity in the ViewModel,
        you end up with references that point to the destroyed Activity
 */
public class WordViewModel extends AndroidViewModel {
    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        mRepository.insert(word);
    }

    public void deleteAllWords() {
        mRepository.deleteAllWords();
    }

    public void deleteWord(Word word) {
        mRepository.deleteWord(word);
    }
}
