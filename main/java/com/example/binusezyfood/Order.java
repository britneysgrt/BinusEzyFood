package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class Order extends AppCompatActivity {

    TextView itemName;
    TextView itemPrice;
    EditText itemQty;
    String name;
    int price;

    ArrayList<OrderAttributes> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        name = intent.getStringExtra("itemName");
        price = intent.getIntExtra("itemPrice", 0);

        itemName = (TextView)findViewById(R.id.itemName);
        itemPrice = (TextView)findViewById(R.id.itemPrice);

        itemName.setText(name);
        itemPrice.setText("Rp " + String.valueOf(price));

        itemQty = (EditText) findViewById(R.id.itemQty);
    }

    public void myOrder(View view){
        String temp = itemQty.getText().toString();
        int qty = Integer.parseInt(temp);

        orderList = DataHolder.getInstance().orderList;

        int isExist = 0;

        for (int i = 0; i < orderList.size(); i++){
            OrderAttributes orderAttributes = orderList.get(i);

            if (orderAttributes.name.equalsIgnoreCase(name)){
                orderAttributes.qty += qty;
                orderAttributes.subtotal += qty*price;
                isExist = 1;
                break;
            }
        }

        if (isExist == 0){
            OrderAttributes order = new OrderAttributes();
            order.name = name;
            order.price = price;
            order.qty = qty;
            order.subtotal = qty*price;

            orderList.add(order);
        }

        Intent openMyOrder = new Intent(this, myOrder.class);
        startActivity(openMyOrder);
    }

    public void drinksMenu(View view){
        String temp = itemQty.getText().toString();
        int qty = Integer.parseInt(temp);

        int isExist = 0;

        orderList = DataHolder.getInstance().orderList;

        for (int i = 0; i < orderList.size(); i++){
            OrderAttributes orderAttributes = orderList.get(i);

            if (orderAttributes.name.equalsIgnoreCase(name)){
                orderAttributes.qty = orderAttributes.qty + qty;
                orderAttributes.subtotal = orderAttributes.subtotal + qty*price;
                isExist = 1;
                break;
            }
        }

        if (isExist == 0){
            OrderAttributes order = new OrderAttributes();
            order.name = name;
            order.price = price;
            order.qty = qty;
            order.subtotal = qty*price;

            orderList.add(order);
        }

        Intent openMainMenu = new Intent(this, MainActivity.class);
        startActivity(openMainMenu);
    }
}
