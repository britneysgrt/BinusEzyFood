package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class myOrder extends AppCompatActivity {

    ArrayList<OrderAttributes> orderList = DataHolder.getInstance().orderList;
    RecyclerView rvMyOrder;
    MyOrderAdapter myOrderAdapter;
    TextView totalPrice;
    TextView isiSaldo;
    int sum = 0;
    int saldo = Topup.saldoTopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        Intent intent = getIntent();

        isiSaldo = (TextView) findViewById(R.id.isiSaldo);
        totalPrice = (TextView) findViewById(R.id.totalPrice);
        for (int i = 0;i < orderList.size();i++){
            OrderAttributes order = orderList.get(i);
            sum += order.subtotal;
        }
        totalPrice.setText("Total: Rp. " + sum);
        isiSaldo.setText("Rp " + saldo);

        rvMyOrder = findViewById(R.id.orderView);
        rvMyOrder.setLayoutManager(new LinearLayoutManager(this));

        myOrderAdapter = new MyOrderAdapter(this, orderList);
        rvMyOrder.setAdapter(myOrderAdapter);
    }

    public void orderComplete(View view){
        if (Topup.saldoTopup < sum){
            Intent openErrorPage = new Intent(this, ErrorTopup.class);
            startActivity(openErrorPage);
        }else{
            Topup.saldoTopup -= sum;

            Intent openOrderComplete = new Intent(this, OrderComplete.class);
            startActivity(openOrderComplete);
        }
    }

    public void topUp(View view) {
        Intent openTopup = new Intent(this, Topup.class);
        startActivity(openTopup);
    }
}
