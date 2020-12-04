package com.example.binusezyfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderCompleteAdapter extends RecyclerView.Adapter<OrderCompleteAdapter.ViewHolder> {

    Context context;
    ArrayList<OrderAttributes> orderList = DataHolder.getInstance().orderList;

    public OrderCompleteAdapter(Context context, ArrayList<OrderAttributes> orderList){
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderCompleteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_complete_row, parent, false);
        return new OrderCompleteAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderCompleteAdapter.ViewHolder holder, int position) {
        OrderAttributes order = orderList.get(position);
        holder.itemName.setText(order.name);

        String itemDetail = order.qty + " x Rp " + order.price;
        holder.itemPrice.setText(itemDetail);
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemName;
        TextView itemPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);
        }
    }
}
