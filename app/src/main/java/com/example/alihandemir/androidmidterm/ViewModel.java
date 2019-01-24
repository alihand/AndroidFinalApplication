package com.example.alihandemir.androidmidterm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private Repository mRepository;
    private LiveData<List<ItemDetail>> mAllItems;

    public ViewModel (Application application) {
        super(application);
        mRepository = new Repository(application);
        mAllItems = mRepository.getmAllItems();
    }

    LiveData<List<ItemDetail>> getAllItems() { return mAllItems; }

    public void insert(ItemDetail item) { mRepository.insert(item); }

    public void delete(ItemDetail item){mRepository.delete(item);}

}


