package com.example.shoppingapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

@Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertProduct(Product product);

@Query("DELETE FROM product_table")
    void deleteAllProducts();

@Query("SELECT * FROM product_table ORDER BY productName ASC")
    LiveData<List<Product>> getAllProductsListLiveData();


}
