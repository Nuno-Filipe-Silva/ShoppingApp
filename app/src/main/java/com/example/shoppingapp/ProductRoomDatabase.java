package com.example.shoppingapp;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;

@Database(entities = {Product.class, Order.class}, version = 4, exportSchema = false)
public abstract class ProductRoomDatabase extends RoomDatabase {

    public abstract ProductDao productDao();

    public abstract OrderDao orderDao();

    private static ProductRoomDatabase INSTANCE;

    static ProductRoomDatabase getDatabase(final Context context) {

        if (INSTANCE == null) {

            synchronized (ProductRoomDatabase.class) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProductRoomDatabase.class, "product_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(callback)
                            .build();

                }

            }

        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            new PopulateDbAsync(INSTANCE).execute();

        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final ProductDao mProductDao;

        private final OrderDao mOrderDao;

        String[] products = {"product1", "product2", "product3", "product4", "product5"};

        PopulateDbAsync(ProductRoomDatabase productRoomDatabase) {

            mProductDao = productRoomDatabase.productDao();

            mOrderDao = productRoomDatabase.orderDao();


        }

        @Override
        protected Void doInBackground(final Void... params) {

            mProductDao.deleteAllProducts();


            for (int i = 0; i < products.length; i++) {

                Product product = new Product(products[i]);

                mProductDao.insertProduct(product);

            }

            return null;

        }
    }

}












