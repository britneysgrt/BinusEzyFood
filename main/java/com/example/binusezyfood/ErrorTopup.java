package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ErrorTopup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_topup);
    }

    public void topUp(View view) {
        Intent openTopup = new Intent(this, Topup.class);
        startActivity(openTopup);
    }
}
