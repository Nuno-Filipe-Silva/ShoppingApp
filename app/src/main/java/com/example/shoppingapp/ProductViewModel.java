package com.example.shoppingapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private ProductRepository mProductRepository;

    private LiveData<List<Product>> mAllProductListLiveData;

    public ProductViewModel(Application application) {

        super(application);

        mProductRepository = new ProductRepository(application);

        mAllProductListLiveData = mProductRepository.getAllProductsListLiveData();

    }

    LiveData<List<Product>> getAllProductListLiveData() {

        return mAllProductListLiveData;

    }

    public void insertProduct(Product product) {

        mProductRepository.insertProduct(product);

    }

}












