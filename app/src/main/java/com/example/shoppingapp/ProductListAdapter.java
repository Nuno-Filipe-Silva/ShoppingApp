package com.example.shoppingapp;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder> {

    private ImageButton button;

    private final LayoutInflater mLayoutInflater;

    private List<Product> mProductList;

    private Order mOrder;

    private OrderDao orderDao;

    private OrderedProductsViewModel orderedProductsViewModel;

    private Application application = new Application();


    ProductListAdapter(Context context) {

        mLayoutInflater = LayoutInflater.from(context);

    }

    class ProductListViewHolder extends RecyclerView.ViewHolder {

        private final TextView productNameItemTV;

        private ProductListViewHolder(View itemView) {

            super(itemView);

            button = itemView.findViewById(R.id.button);

            productNameItemTV = itemView.findViewById(R.id.textView);

        }

    }

    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        orderedProductsViewModel = new OrderedProductsViewModel(application);

        View itemView = mLayoutInflater.inflate(R.layout.recyclerview_product_item, parent, false);

        return new ProductListViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.ProductListViewHolder holder, int position) {

        if (mProductList != null) {

            final Product currentProduct = mProductList.get(position);

            holder.productNameItemTV.setText(currentProduct.getProductName());

            final String clickedToAdd = currentProduct.getProductName();


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    orderedProductsViewModel.insertProduct(new Order(clickedToAdd));


                }

            });

        } else {

            holder.productNameItemTV.setText("No Product");

        }

    }

    void setProducts(List<Product> productList) {

        mProductList = productList;

        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {

        if (mProductList != null) {

            return mProductList.size();

        } else {

            return 0;

        }

    }

}
