package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProductViewModel mProductViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);

        final ProductListAdapter productListAdapter = new ProductListAdapter(this);

        recyclerView.setAdapter(productListAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mProductViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);

        mProductViewModel.getAllProductListLiveData().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {

                productListAdapter.setProducts(products);

            }
        });

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, OrderedProductsActivity.class);

                startActivity(intent);

            }
        });

    }
}