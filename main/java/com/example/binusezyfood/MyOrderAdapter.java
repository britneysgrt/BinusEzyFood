package com.example.binusezyfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {

    Context context;
    ArrayList<OrderAttributes> orderList = DataHolder.getInstance().orderList;
    String itemName;

    public MyOrderAdapter(Context context, ArrayList<OrderAttributes> orderList){
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public MyOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.ViewHolder holder, int position) {
        final OrderAttributes order = orderList.get(position);
        itemName = order.name;
        holder.itemName.setText(order.name);

        String itemDetail = order.qty + " x Rp " + order.price;
        holder.itemPrice.setText(itemDetail);

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = 0;
                for (int i = 0; i < orderList.size(); i++){
                    OrderAttributes order2 = orderList.get(i);
                    if(order.name.equals(order2.name)){
                        position = i;
                        break;
                    }
                }
                orderList.remove(position);

                Intent openMyOrder = new Intent(context, myOrder.class);
                context.startActivity(openMyOrder);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemName;
        TextView itemPrice;
        Button deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);

            deleteBtn = (Button) itemView.findViewById(R.id.deleteBtn);
        }
    }
}
