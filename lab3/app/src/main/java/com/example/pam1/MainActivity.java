package com.example.pam1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText edt0;
    private EditText edt1;
    private EditText edt2;
    private Button butt;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt0 = findViewById(R.id.licz1);
        edt1 = findViewById(R.id.znak);
        edt2 = findViewById(R.id.licz2);
        butt = findViewById(R.id.add);
        ;
        res = findViewById(R.id.liczres);

        edt0.setOnFocusChangeListener(myOwnOnFocusChangeListener);
        edt1.setOnFocusChangeListener(myOwnOnFocusChangeListener);
        edt2.setOnFocusChangeListener(myOwnOnFocusChangeListener);
        butt.setOnClickListener(myOwnClick);
        butt.setOnLongClickListener(loggg);
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
                res.setText("WTF");
                break;
        }
    };

    private View.OnLongClickListener loggg = v -> {
        showToast();
        return false;
    };

    private void showToast() {
        Toast.makeText(MainActivity.this,"Programowanie Aplikacji Mobilnych",
                Toast.LENGTH_SHORT).show();
    }

    private View.OnFocusChangeListener myOwnOnFocusChangeListener = (v, hasFocus) -> checkInput();

    public void checkInput() {
        if (!edt1.getText().toString().contains("+") && !edt1.getText().toString().contains("-") && !edt1.getText().toString().contains("*") && !edt1.getText().toString().contains("/")) {
            res.setText("math sign should be one of: +, -, *, /");
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
        EditText l1 = findViewById(R.id.licz1);
        EditText l2 = findViewById(R.id.licz2);
        TextView result = findViewById(R.id.liczres);

        result.setText(l1.getText() + " + " + l2.getText() + " = " + String.valueOf(Float.parseFloat(l1.getText().toString()) + Float.parseFloat(l2.getText().toString())));
    }

    public void sub() {
        EditText l1 = findViewById(R.id.licz1);
        EditText l2 = findViewById(R.id.licz2);
        TextView result = findViewById(R.id.liczres);

        result.setText(l1.getText() + " - " + l2.getText() + " = " + String.valueOf(Float.parseFloat(l1.getText().toString()) - Float.parseFloat(l2.getText().toString())));
    }

    public void mult() {
        EditText l1 = findViewById(R.id.licz1);
        EditText l2 = findViewById(R.id.licz2);
        TextView result = findViewById(R.id.liczres);

        result.setText(l1.getText() + " * " + l2.getText() + " = " + String.valueOf(Float.parseFloat(l1.getText().toString()) * Float.parseFloat(l2.getText().toString())));
    }

    public void div() {
        EditText l1 = findViewById(R.id.licz1);
        EditText l2 = findViewById(R.id.licz2);
        TextView result = findViewById(R.id.liczres);

        if (Integer.parseInt(l2.getText().toString()) == 0) {
            result.setText("Cant div on 0");
            return;
        }

        result.setText(l1.getText() + " / " + l2.getText() + " = " + String.valueOf(Float.parseFloat(l1.getText().toString()) / Float.parseFloat(l2.getText().toString())));
    }
}