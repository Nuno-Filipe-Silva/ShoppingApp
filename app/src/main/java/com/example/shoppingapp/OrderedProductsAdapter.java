package com.example.shoppingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderedProductsAdapter extends RecyclerView.Adapter<OrderedProductsAdapter.OrderedProductsViewHolder> {

    private final LayoutInflater mLayoutInflater;

    private List<Order> mOrderedProductsList;

    public OrderedProductsAdapter(Context context) {

        mLayoutInflater = LayoutInflater.from(context);

    }

    class OrderedProductsViewHolder extends RecyclerView.ViewHolder {

        private final TextView orderedProductNameTV;

        private OrderedProductsViewHolder(View itemView) {

            super(itemView);

            orderedProductNameTV = itemView.findViewById(R.id.orderedProductNameTV);

        }

    }


    @NonNull
    @Override
    public OrderedProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = mLayoutInflater.inflate(R.layout.recyclerview_ordered_product_item, parent, false);

        return new OrderedProductsViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull OrderedProductsAdapter.OrderedProductsViewHolder holder, int position) {

        if (mOrderedProductsList != null) {

            final Order currentOrder = mOrderedProductsList.get(position);

            holder.orderedProductNameTV.setText(currentOrder.getNameProductOrdered());

        }

    }

    void setOrderedProductsList(List<Order> orderedProductsList) {

        mOrderedProductsList = orderedProductsList;

        notifyDataSetChanged();


    }


    @Override
    public int getItemCount() {

        if (mOrderedProductsList != null) {

            return mOrderedProductsList.size();

        } else {

            return 0;

        }

    }

}
