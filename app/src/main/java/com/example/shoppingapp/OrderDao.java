package com.example.shoppingapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addProductToOrder(Order productOrderedName);

    @Query("SELECT * FROM ORDER_TABLE")
    LiveData<List<Order>> getOrderedProductListLiveDataDao();



}
