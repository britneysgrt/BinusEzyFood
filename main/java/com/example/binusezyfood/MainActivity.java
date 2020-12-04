package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void drinksMenu(View view){
        Intent openDrinksMenu = new Intent(this, drinksMenu.class);
        startActivity(openDrinksMenu);
    }

    public void myOrder(View view){
        Intent openMyOrder = new Intent(this, myOrder.class);
        startActivity(openMyOrder);
    }

    public void snacksMenu(View view) {
        Intent openSnacksMenu = new Intent(this, SnacksMenu.class);
        startActivity(openSnacksMenu);
    }

    public void foodsMenu(View view) {
        Intent openFoodsMenu = new Intent(this, FoodsMenu.class);
        startActivity(openFoodsMenu);
    }

    public void topupMenu(View view) {
        Intent openTopup = new Intent(this, Topup.class);
        startActivity(openTopup);
    }
}
