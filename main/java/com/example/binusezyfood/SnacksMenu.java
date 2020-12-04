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

public class SnacksMenu extends AppCompatActivity {

    ArrayList<Menu> snacksList;
    RecyclerView rvSnacks;
    MenuAdapter snacksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks_menu);

        Intent intent = getIntent();

        snacksList = new ArrayList<>();

        Menu snack1 = new Menu();
        snack1.name = "Onion Rings";
        snack1.price = 20000;
        snack1.image = R.drawable.snack1;

        Menu snack2 = new Menu();
        snack2.name = "French Fries";
        snack2.price = 20000;
        snack2.image = R.drawable.snack2;

        Menu snack3 = new Menu();
        snack3.name = "Chicken Nugget";
        snack3.price = 25000;
        snack3.image = R.drawable.snack3;

        Menu snack4 = new Menu();
        snack4.name = "Pisang Goreng";
        snack4.price = 15000;
        snack4.image = R.drawable.snack4;

        snacksList.add(snack1);
        snacksList.add(snack2);
        snacksList.add(snack3);
        snacksList.add(snack4);

        rvSnacks = findViewById(R.id.snacksView);
        rvSnacks.setLayoutManager(new GridLayoutManager(this, 2));

        snacksAdapter = new MenuAdapter(this, snacksList);
        rvSnacks.setAdapter(snacksAdapter);
    }

    public void myOrder(View view){
        Intent openMyOrder = new Intent(this, myOrder.class);
        startActivity(openMyOrder);
    }
}
