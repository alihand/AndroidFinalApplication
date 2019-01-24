
package com.example.alihandemir.androidmidterm;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ItemDao {

    @Query("Select * From items")
    LiveData<List<ItemDetail>> getAllItems();

    @Insert
    void insert(ItemDetail... users);

    @Delete
    void delete(ItemDetail user);

}
