package com.example.shoppingapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductRepository {

    private ProductDao mProductDao;

    private LiveData<List<Product>> mProductListLiveData;

    ProductRepository(Application application) {

        ProductRoomDatabase productRoomDatabase = ProductRoomDatabase.getDatabase(application);

        mProductDao = productRoomDatabase.productDao();

        mProductListLiveData = mProductDao.getAllProductsListLiveData();

    }

    LiveData<List<Product>> getAllProductsListLiveData() {

        return mProductListLiveData;

    }

    public void insertProduct(Product product) {

        new insertAsyncTask(mProductDao).execute(product);

    }


    private static class insertAsyncTask extends AsyncTask<Product, Void, Void> {

        private ProductDao mProductDaoAsyncTask;

        insertAsyncTask(ProductDao productDao) {

            mProductDaoAsyncTask = productDao;

        }

        @Override
        protected Void doInBackground(Product... products) {

            mProductDaoAsyncTask.insertProduct(products[0]);

            return null;

        }
    }

}










