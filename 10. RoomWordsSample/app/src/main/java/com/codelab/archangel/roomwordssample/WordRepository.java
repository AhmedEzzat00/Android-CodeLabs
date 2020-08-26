package com.codelab.archangel.roomwordssample;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    private WordDAO mWordDAO;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDAO = db.wordDAO();
        mAllWords = mWordDAO.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        new insertAsyncTask(mWordDAO).execute(word);
    }
    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDAO mAsyncTaskDao;

        public insertAsyncTask(WordDAO wordDAO) {
            mAsyncTaskDao = wordDAO;
        }

        @Override
        protected Void doInBackground(final Word... words) {
            mAsyncTaskDao.insert(words[0]);
            return null;
        }
    }


    public void deleteAllWords() {
        new deleteAllWordsAsyncTask(mWordDAO).execute();
    }

    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private WordDAO mWordDAO;

        public deleteAllWordsAsyncTask(WordDAO wordDAO) {
            this.mWordDAO = wordDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mWordDAO.deleteAll();
            return null;
        }
    }

    public void deleteWord(Word word) {
        new deleteWordAsyncTask(mWordDAO).execute(word);
    }

    private static class deleteWordAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDAO mWordDAO;

        public deleteWordAsyncTask(WordDAO wordDAO) {
        }

        @Override
        protected Void doInBackground(final Word... words) {
            mWordDAO.deleteWord(words[0]);
            return null;
        }
    }
}
