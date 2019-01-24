package com.example.alihandemir.androidmidterm;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class Repository {

    private ItemDao mItemDao;
    private LiveData<List<ItemDetail>> mAllItems;

    public Repository(Application application) {
        AppDatabase db = AppDatabase.getAppDatabase(application);
        mItemDao = db.itemDao();
        mAllItems = mItemDao.getAllItems();
    }

    public  LiveData<List<ItemDetail>> getmAllItems() {
        return mAllItems;
    }

    public void insert (ItemDetail word) {
        new insertAsyncTask(mItemDao).execute(word);
    }

    public void delete (ItemDetail word) {
        new deleteAsyncTask(mItemDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<ItemDetail, Void, Void> {

        private ItemDao mAsyncTaskDao;

        public insertAsyncTask(ItemDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ItemDetail... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<ItemDetail, Void, Void> {

        private ItemDao mAsyncTaskDao;

        public deleteAsyncTask(ItemDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ItemDetail... params) {
            mAsyncTaskDao.delete(params[0]);
            return null;
        }
    }

}

