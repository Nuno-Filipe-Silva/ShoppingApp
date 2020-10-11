package com.example.shoppingapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product_table")
public class Product {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "productName")
    private String mProductName;

    public Product(@NonNull String productName) {

        this.mProductName = productName;

    }

    public String getProductName() {

        return mProductName;

    }

}
