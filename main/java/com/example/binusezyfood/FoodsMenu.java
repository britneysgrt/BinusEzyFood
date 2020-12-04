package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class FoodsMenu extends AppCompatActivity {

    ArrayList<Menu> foodsList;
    RecyclerView rvFoods;
    MenuAdapter drinksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods_menu);

        Intent intent = getIntent();

        foodsList = new ArrayList<>();

        Menu food1 = new Menu();
        food1.name = "Nasi Goreng";
        food1.price = 30000;
        food1.image = R.drawable.food1;

        Menu food2 = new Menu();
        food2.name = "Mie Goreng";
        food2.price = 30000;
        food2.image = R.drawable.food2;

        Menu food3 = new Menu();
        food3.name = "Nasi Kuning";
        food3.price = 25000;
        food3.image = R.drawable.food3;

        Menu food4 = new Menu();
        food4.name = "Kwetiaw";
        food4.price = 35000;
        food4.image = R.drawable.food4;

        foodsList.add(food1);
        foodsList.add(food2);
        foodsList.add(food3);
        foodsList.add(food4);

        rvFoods = findViewById(R.id.foodsView);
        rvFoods.setLayoutManager(new GridLayoutManager(this, 2));

        drinksAdapter = new MenuAdapter(this, foodsList);
        rvFoods.setAdapter(drinksAdapter);
    }

    public void myOrder(View view){
        Intent openMyOrder = new Intent(this, myOrder.class);
        startActivity(openMyOrder);
    }
}
