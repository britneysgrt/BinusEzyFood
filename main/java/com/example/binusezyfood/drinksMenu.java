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

public class drinksMenu extends AppCompatActivity {

    ArrayList<Menu> drinksList;
    RecyclerView rvDrinks;
    MenuAdapter drinksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_menu);

        Intent intent = getIntent();

        drinksList = new ArrayList<>();

        Menu drink1 = new Menu();
        drink1.name = "Air Mineral";
        drink1.price = 10000;
        drink1.image = R.drawable.drink1;

        Menu drink2 = new Menu();
        drink2.name = "Jus Apel";
        drink2.price = 15000;
        drink2.image = R.drawable.drink2;

        Menu drink3 = new Menu();
        drink3.name = "Jus Mangga";
        drink3.price = 20000;
        drink3.image = R.drawable.drink3;

        Menu drink4 = new Menu();
        drink4.name = "Jus Alpukat";
        drink4.price = 18000;
        drink4.image = R.drawable.drink4;

        drinksList.add(drink1);
        drinksList.add(drink2);
        drinksList.add(drink3);
        drinksList.add(drink4);

        rvDrinks = findViewById(R.id.drinksView);
        rvDrinks.setLayoutManager(new GridLayoutManager(this, 2));

        drinksAdapter = new MenuAdapter(this, drinksList);
        rvDrinks.setAdapter(drinksAdapter);
    }

    public void myOrder(View view){
        Intent openMyOrder = new Intent(this, myOrder.class);
        startActivity(openMyOrder);
    }
}
