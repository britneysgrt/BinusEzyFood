package com.example.binusezyfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    Context context;
    ArrayList<Menu> menuList;

    public MenuAdapter(Context context, ArrayList<Menu> menuList){
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        Menu menu = menuList.get(position);
        holder.itemImg.setImageResource(menu.image);
        holder.itemName.setText(menu.name);
        holder.itemPrice.setText("Rp " + Integer.toString(menu.price));
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView itemImg;
        TextView itemName;
        TextView itemPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImg = itemView.findViewById(R.id.itemImg);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Menu menu = menuList.get(position);

            String name = menu.name;
            int price = menu.price;
            Intent openOrder = new Intent(context, Order.class);
            openOrder.putExtra("itemName", name);
            openOrder.putExtra("itemPrice", price);
            context.startActivity(openOrder);
        }
    }
}
