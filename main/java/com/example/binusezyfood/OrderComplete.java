package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderComplete extends AppCompatActivity {

    ArrayList<OrderAttributes> orderList = DataHolder.getInstance().orderList;
    RecyclerView rvOrderComplete;
    OrderCompleteAdapter orderCompleteAdapter;
    TextView totalPrice;
    TextView isiSaldo;
    int sum = 0;
    int saldo = Topup.saldoTopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        Intent intent = getIntent();

        isiSaldo = (TextView) findViewById(R.id.isiSaldo);
        totalPrice = (TextView) findViewById(R.id.totalPrice);
        for (int i = 0;i < orderList.size();i++){
            OrderAttributes order = orderList.get(i);
            sum += order.subtotal;
        }
        totalPrice.setText("Total: Rp. " + sum);
        isiSaldo.setText("Rp " + saldo);

        rvOrderComplete = findViewById(R.id.orderCompleteView);
        rvOrderComplete.setLayoutManager(new LinearLayoutManager(this));

        orderCompleteAdapter = new OrderCompleteAdapter(this, orderList);
        rvOrderComplete.setAdapter(orderCompleteAdapter);
    }

    public void mainMenu(View view){
        orderList.clear();
        Intent openMainMenu = new Intent(this, MainActivity.class);
        startActivity(openMainMenu);
    }
}
