package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

public class OrderedProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered_products);

        ImageButton button = findViewById(R.id.removeFromOrderButton);

        final RecyclerView recyclerView = findViewById(R.id.orderedProductsRecyclerview);

        final OrderedProductsAdapter orderedProductsAdapter = new OrderedProductsAdapter(this);

        recyclerView.setAdapter(orderedProductsAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        OrderedProductsViewModel orderedProductsViewModel = ViewModelProviders.of(this).get(OrderedProductsViewModel.class);

        orderedProductsViewModel.getOrderedProductsListLiveDataVM().observe(this, new Observer<List<Order>>() {
                    @Override
                    public void onChanged(List<Order> orders) {

                        orderedProductsAdapter.setOrderedProductsList(orders);

                        recyclerView.getAdapter().notifyDataSetChanged();

                    }
                }

        );


    }

}