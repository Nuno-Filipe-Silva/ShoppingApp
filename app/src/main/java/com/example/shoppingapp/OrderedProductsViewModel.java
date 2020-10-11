package com.example.shoppingapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class OrderedProductsViewModel extends AndroidViewModel {

    private OrderedProductsRepository orderedProductsRepository;

    private LiveData<List<Order>> orderedProductsListLiveData;

    public OrderedProductsViewModel(Application application) {

        super(application);

        orderedProductsRepository = new OrderedProductsRepository(application);

        orderedProductsListLiveData = orderedProductsRepository.getOrderedProductsListLiveData();

    }

    LiveData<List<Order>> getOrderedProductsListLiveDataVM() {

        return orderedProductsListLiveData;

    }

    public void insertProduct(Order order) {

        orderedProductsRepository.insertOrder(order);

    }


}
