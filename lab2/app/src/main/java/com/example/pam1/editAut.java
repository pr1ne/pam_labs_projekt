package com.example.pam1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class editAut extends AppCompatActivity {

    private EditText im;
    private EditText naz;
    private EditText kier;
    private EditText rok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ediaut);

        im = findViewById(R.id.imie);
        naz = findViewById(R.id.nazwisko);
        kier = findViewById(R.id.kierunek);
        rok = findViewById(R.id.rok);

        if (getIntent().getExtras() != null) {
            im.setText(getIntent().getStringExtra("imie"));
            naz.setText(getIntent().getStringExtra("nazwisko"));
            kier.setText(getIntent().getStringExtra("kierunek"));
            rok.setText(getIntent().getStringExtra("rok"));
        }
    }

    public void save(View v) {
        Intent runSecondIntent = new Intent(this, autor.class);
        runSecondIntent.putExtra("imie", im.getText().toString());
        runSecondIntent.putExtra("nazwisko", naz.getText().toString());
        runSecondIntent.putExtra("kierunek", kier.getText().toString());
        runSecondIntent.putExtra("rok", rok.getText().toString());
        startActivity(runSecondIntent);
    }

    public void backHome(View v) {
        Intent runSecondIntent = new Intent(this, MainActivity.class);
        startActivity(runSecondIntent);
    }
}
