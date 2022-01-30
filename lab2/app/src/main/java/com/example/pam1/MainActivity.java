package com.example.pam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Button butt;
    private Button buttcalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butt = findViewById(R.id.oaut);
        buttcalc = findViewById(R.id.calc);

        buttcalc.setOnClickListener(myOwnClick);
        butt.setOnClickListener(myOwnClick);
    }

    private View.OnClickListener myOwnClick = v -> {
        Intent runSecondIntent;
        switch (v.getId()) {
            case R.id.oaut:
                runSecondIntent = new Intent(this, autor.class);
                startActivity(runSecondIntent);
                break;
            case R.id.calc:
                runSecondIntent = new Intent(this, calc.class);
                startActivity(runSecondIntent);
                break;
            default:
                break;
        }
    };
}