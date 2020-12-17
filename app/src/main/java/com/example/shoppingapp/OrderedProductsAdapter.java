package com.example.shoppingapp;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderedProductsAdapter extends RecyclerView.Adapter<OrderedProductsAdapter.OrderedProductsViewHolder> {

    private ImageButton button;

    private final LayoutInflater mLayoutInflater;

    private List<Order> mOrderedProductsList;

    private OrderedProductsViewModel orderedProductsViewModel;

    private Application application = new Application();


    public OrderedProductsAdapter(Context context) {

        mLayoutInflater = LayoutInflater.from(context);

    }

    class OrderedProductsViewHolder extends RecyclerView.ViewHolder {

        private final TextView orderedProductNameTV;

        private OrderedProductsViewHolder(View itemView) {

            super(itemView);

            button = itemView.findViewById(R.id.removeFromOrderButton);

            orderedProductNameTV = itemView.findViewById(R.id.orderedProductNameTV);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();

                    Order order = mOrderedProductsList.get(position);

                    orderedProductsViewModel.removeProductFromOrder(order);

                    notifyDataSetChanged();

                    mOrderedProductsList.remove(position);

                    notifyItemRemoved(getAdapterPosition());

                    //TODO a mOrderedProductsList não está a actualizar a currentPosition.
                    //TODO o a order está na currentPosition 0, mas aparece 4, p.ex.
                    // TODO parece estar a funcionar
                }
            });


        }



    }


    @NonNull
    @Override
    public OrderedProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        orderedProductsViewModel = new OrderedProductsViewModel(application);

        View itemView = mLayoutInflater.inflate(R.layout.recyclerview_ordered_product_item, parent, false);

        return new OrderedProductsViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final OrderedProductsAdapter.OrderedProductsViewHolder holder, int position) {

        if (mOrderedProductsList != null) {

            final int currentPosition = holder.getAdapterPosition();

            final Order currentOrder = mOrderedProductsList.get(currentPosition);

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

    public Order getProductAtPosition(int position) {

        return mOrderedProductsList.get(position);

    }

}
