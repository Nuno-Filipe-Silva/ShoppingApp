package com.example.shoppingapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "order_table")
public class Order {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "order_id")
    private int mOrderId;


    @NonNull
    @ColumnInfo(name = "name_product_ordered")
    private String mNameProductOrdered;

    /*@ColumnInfo(name = "products_ordered")
    private List<Product> mOrderedProductList;*/

    public Order() {


    }

    /*public Order(int orderId, String nameProductOrdered) {

        this.mOrderId = orderId;

        this.mNameProductOrdered = nameProductOrdered;

    }*/

    public Order(@NonNull String nameProductOrdered) {

        this.mNameProductOrdered = nameProductOrdered;

    }


    public void setOrderId(int orderId) {

        this.mOrderId = orderId;

    }

    public void setNameProductOrdered(String nameProductOrdered) {

        this.mNameProductOrdered = nameProductOrdered;

    }


    /*public Order(int orderId, Product productAdded) {

        this.mOrderId = orderId;

        if (mOrderedProductList.isEmpty()) {

            this.mOrderedProductList = new ArrayList<>();

        }
        this.mOrderedProductList.add(productAdded);

    }*/

    public String getNameProductOrdered() {

        return mNameProductOrdered;

    }



    public int getOrderId() {

        return mOrderId;

    }


}












