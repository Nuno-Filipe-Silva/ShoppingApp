package com.example.shoppingapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class OrderedProductsRepository {

    private OrderDao mOrderDao;

    private LiveData<List<Order>> mOrderedProductsListLiveData;

    OrderedProductsRepository(Application application) {

        ProductRoomDatabase productRoomDatabase = ProductRoomDatabase.getDatabase(application);

        mOrderDao = productRoomDatabase.orderDao();

        mOrderedProductsListLiveData = mOrderDao.getOrderedProductListLiveDataDao();

    }

    LiveData<List<Order>> getOrderedProductsListLiveData() {

        return mOrderedProductsListLiveData;

    }


    public void insertOrder(Order order) {

        new insertAsyncTask(mOrderDao).execute(order);

    }

    public void removeProductFromOrder(Order order) {

        new removeProductFromOrderAsyncTask(mOrderDao).execute(order);

    }

    private static class insertAsyncTask extends AsyncTask<Order, Void, Void> {

        private OrderDao mOrderDaoAsyncTask;

        insertAsyncTask(OrderDao orderDao) {

            mOrderDaoAsyncTask = orderDao;

        }

        @Override
        protected Void doInBackground(Order... orders) {

            mOrderDaoAsyncTask.addProductToOrder(orders[0]);

            return null;
        }

    }

    private static class removeProductFromOrderAsyncTask extends AsyncTask<Order, Void, Void> {

        private OrderDao mOrderDaoRemoveProductFromOrderAsyncTask;

        removeProductFromOrderAsyncTask(OrderDao orderDao) {

            mOrderDaoRemoveProductFromOrderAsyncTask = orderDao;

        }

        @Override
        protected Void doInBackground(Order... orders) {

            mOrderDaoRemoveProductFromOrderAsyncTask.deleteProductFromOrder(orders[0]);

            return null;
        }
    }


}
