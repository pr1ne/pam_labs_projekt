package com.example.pam1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class autor extends AppCompatActivity {

    private TextView im;
    private TextView naz;
    private TextView kier;
    private TextView rok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autor);

        im = findViewById(R.id.imieA);
        naz = findViewById(R.id.nazwiskoA);
        kier = findViewById(R.id.kierunekA);
        rok = findViewById(R.id.rokA);

        if (getIntent().getExtras() != null) {
            im.setText(getIntent().getStringExtra("imie"));
            naz.setText(getIntent().getStringExtra("nazwisko"));
            kier.setText(getIntent().getStringExtra("kierunek"));
            rok.setText(getIntent().getStringExtra("rok"));
        }
    }

    public void backHome(View v) {
        Intent runSecondIntent = new Intent(this, MainActivity.class);
        startActivity(runSecondIntent);
    }

    public void edit(View v) {
        Intent runSecondIntent = new Intent(this, editAut.class);
        runSecondIntent.putExtra("imie", im.getText());
        runSecondIntent.putExtra("nazwisko", naz.getText());
        runSecondIntent.putExtra("kierunek", kier.getText());
        runSecondIntent.putExtra("rok", rok.getText());
        startActivity(runSecondIntent);
    }
}
