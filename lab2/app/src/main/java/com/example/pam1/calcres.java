package com.example.pam1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calcres extends AppCompatActivity {

    private TextView res;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcres);

        res = findViewById(R.id.resulat);
        res.setText(getIntent().getStringExtra("result"));
    }


    public void backHome(View v) {
        Intent runSecondIntent = new Intent(this, MainActivity.class);
        startActivity(runSecondIntent);
    }
}
