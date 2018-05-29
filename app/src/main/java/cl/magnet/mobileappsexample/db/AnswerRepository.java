package cl.magnet.mobileappsexample.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by mpsan on 29-05-2018.
 */

public class AnswerRepository {

    private AnswerDao mAnswerDao;
    private LiveData<List<Answer>> mAllAnswer;

    AnswerRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mAnswerDao = db.answerDao();
        mAllAnswer = mAnswerDao.getAllAnswers();
    }

    LiveData<List<Answer>> getAllAnswers() {
        return mAllAnswer;
    }

    public void insert (List<Answer> answers) {
        Answer[] answerArray = new Answer[answers.size()];
        answerArray = answers.toArray(answerArray);
        new insertAsyncTask(mAnswerDao).execute(answerArray);
    }

    private static class insertAsyncTask extends AsyncTask<Answer, Void, Void> {

        private AnswerDao mAsyncTaskDao;

        insertAsyncTask(AnswerDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Answer... params) {
            mAsyncTaskDao.insertAll(params);
            return null;
        }
    }
}