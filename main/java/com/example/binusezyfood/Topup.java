package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Topup extends AppCompatActivity {

    public static int saldoTopup = 0;

    TextView currSaldo;
    EditText addSaldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);

        Intent intent = getIntent();

        currSaldo = (TextView) findViewById(R.id.currSaldo);
        addSaldo = (EditText) findViewById(R.id.addSaldo);

        currSaldo.setText("Rp " + saldoTopup);
    }

    public void topUp(View view) {
        String temp = addSaldo.getText().toString();
        saldoTopup += Integer.parseInt(temp);

        Intent intent = new Intent(this, Topup.class);
        startActivity(intent);
    }

    public void mainMenu(View view) {
        Intent openMainMenu = new Intent(this, MainActivity.class);
        startActivity(openMainMenu);
    }

    public void myOrder(View view) {
        Intent openMyOrder = new Intent(this, myOrder.class);
        startActivity(openMyOrder);
    }
}
