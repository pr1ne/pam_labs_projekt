package com.example.pam1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void check(View v) {
        EditText grade = findViewById(R.id.editTextAvGrade);
        EditText kier = findViewById(R.id.editTextSubject);

        TextView im = findViewById(R.id.editTextName);
        TextView naz = findViewById(R.id.editTextSurname);

        TextView result = findViewById(R.id.textViewResult);
        TextView comunikat = findViewById(R.id.com);

        double avGrade = Double.parseDouble(grade.getText().toString());

        if (avGrade < 4.5)
            result.setText(R.string.nie_ot_st);
        else
            result.setText(R.string.ot_styp);

        comunikat.setText(im.getText().toString() + " " + naz.getText().toString() + getString(R.string.z_ker) + kier.getText() + " " + (avGrade < 4.5 ? getString(R.string.nie_ot_st) : getString(R.string.ot_styp)));
    }

    public void add(View v) {
        EditText l1 = findViewById(R.id.licz1);
        EditText l2 = findViewById(R.id.licz2);
        TextView result = findViewById(R.id.liczres);

        result.setText(l1.getText() + " + " + l2.getText() + " = " + String.valueOf(Integer.parseInt(l1.getText().toString()) + Integer.parseInt(l2.getText().toString())));
    }

    public void sub(View v) {
        EditText l1 = findViewById(R.id.licz1);
        EditText l2 = findViewById(R.id.licz2);
        TextView result = findViewById(R.id.liczres);

        result.setText(l1.getText() + " - " + l2.getText() + " = " + String.valueOf(Integer.parseInt(l1.getText().toString()) - Integer.parseInt(l2.getText().toString())));
    }

    public void mult(View v) {
        EditText l1 = findViewById(R.id.licz1);
        EditText l2 = findViewById(R.id.licz2);
        TextView result = findViewById(R.id.liczres);

        result.setText(l1.getText() + " * " + l2.getText() + " = " + String.valueOf(Integer.parseInt(l1.getText().toString()) * Integer.parseInt(l2.getText().toString())));
    }

    public void div(View v) {
        EditText l1 = findViewById(R.id.licz1);
        EditText l2 = findViewById(R.id.licz2);
        TextView result = findViewById(R.id.liczres);

        if (Integer.parseInt(l2.getText().toString()) == 0) {
            result.setText("Cant div on 0");
            return;
        }

        result.setText(l1.getText() + " / " + l2.getText() + " = " + String.valueOf(Integer.parseInt(l1.getText().toString()) / Integer.parseInt(l2.getText().toString())));
    }

    public void how(View v) {
        EditText l1 = findViewById(R.id.pol1);
        EditText l2 = findViewById(R.id.pol2);
        TextView result = findViewById(R.id.res1);
        TextView result2 = findViewById(R.id.res2);

        String chars = "";
        String str = "";

        int[] t = new int[l1.getText().toString().length()];
        int k = 0;

        for (char c : l1.getText().toString().toCharArray()) {
            if (!chars.contains(new StringBuilder(1).append(c))) {
                chars += c;
                t[k] = l1.getText().toString().split(Character.toString(c), -1).length - 1;
                k++;
            }
        }
        k = 0;

        for (char c : chars.toCharArray()) {
            str += c + " - " + t[k] + ", ";
            k++;
        }


        result2.setText(str);

        result.setText(String.valueOf(l1.getText().toString().split(l2.getText().toString(), -1).length - 1));
    }
}