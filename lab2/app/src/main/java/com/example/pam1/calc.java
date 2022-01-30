package com.example.pam1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class calc extends AppCompatActivity {

    private EditText edt0;
    private EditText edt1;
    private EditText edt2;
    private Button butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);

        edt0 = findViewById(R.id.licz1);
        edt1 = findViewById(R.id.znak);
        edt2 = findViewById(R.id.licz2);
        butt = findViewById(R.id.add);

        edt0.setOnFocusChangeListener(myOwnOnFocusChangeListener);
        edt1.setOnFocusChangeListener(myOwnOnFocusChangeListener);
        edt2.setOnFocusChangeListener(myOwnOnFocusChangeListener);
        butt.setOnClickListener(myOwnClick);
    }

    private View.OnClickListener myOwnClick = v -> {
        switch (edt1.getText().toString()) {
            case "+":
                add();
                break;
            case "-":
                sub();
                break;
            case "*":
                mult();
                break;
            case "/":
                div();
                break;
            default:
                break;
        }
    };

    private View.OnFocusChangeListener myOwnOnFocusChangeListener = (v, hasFocus) -> checkInput();

    public void checkInput() {
        if (!edt1.getText().toString().contains("+") && !edt1.getText().toString().contains("-") && !edt1.getText().toString().contains("*") && !edt1.getText().toString().contains("/")) {
            butt.setVisibility(Button.INVISIBLE);
        } else {
            if (edt0.getText().length() > 0 && edt2.getText().length() > 0){
                if (!edt0.getText().toString().contains(" ") && !edt2.getText().toString().contains(" ") && !Pattern.matches("[a-zA-Z]+", edt0.getText()) && !Pattern.matches("[a-zA-Z]+", edt2.getText()) && !Pattern.matches("[а-яА-Я]+", edt0.getText()) && !Pattern.matches("[а-яА-Я]+", edt2.getText()))
                    butt.setVisibility(Button.VISIBLE);
                else
                    butt.setVisibility(Button.INVISIBLE);
            }
            else
                butt.setVisibility(Button.INVISIBLE);
        }

    }

    public void add() {

        Intent runSecondIntent = new Intent(this, calcres.class);

        EditText l1 = findViewById(R.id.licz1);
        EditText l2 = findViewById(R.id.licz2);

        runSecondIntent.putExtra("result",l1.getText() + " + " + l2.getText() + " = " + String.valueOf(Float.parseFloat(l1.getText().toString()) + Float.parseFloat(l2.getText().toString())));
        startActivity(runSecondIntent);
    }

    public void sub() {
        Intent runSecondIntent = new Intent(this, calcres.class);

        EditText l1 = findViewById(R.id.licz1);
        EditText l2 = findViewById(R.id.licz2);

        runSecondIntent.putExtra("result",l1.getText() + " - " + l2.getText() + " = " + String.valueOf(Float.parseFloat(l1.getText().toString()) - Float.parseFloat(l2.getText().toString())));
        startActivity(runSecondIntent);
    }

    public void mult() {
        Intent runSecondIntent = new Intent(this, calcres.class);

        EditText l1 = findViewById(R.id.licz1);
        EditText l2 = findViewById(R.id.licz2);

        runSecondIntent.putExtra("result",l1.getText() + " * " + l2.getText() + " = " + String.valueOf(Float.parseFloat(l1.getText().toString()) * Float.parseFloat(l2.getText().toString())));
        startActivity(runSecondIntent);
    }

    public void div() {
        Intent runSecondIntent = new Intent(this, calcres.class);

        EditText l1 = findViewById(R.id.licz1);
        EditText l2 = findViewById(R.id.licz2);

        if (Integer.parseInt(l2.getText().toString()) == 0) {
            runSecondIntent.putExtra("result","Cant div on 0");
            return;
        }

        runSecondIntent.putExtra("result",l1.getText() + " / " + l2.getText() + " = " + String.valueOf(Float.parseFloat(l1.getText().toString()) / Float.parseFloat(l2.getText().toString())));
        startActivity(runSecondIntent);
    }
}
