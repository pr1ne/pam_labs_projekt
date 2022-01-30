package com.example.pam1

import android.os.Bundle
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.View.OnLongClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener {
    private lateinit var edt0: EditText
    private lateinit var edt1: EditText
    private lateinit var edt2: EditText
    private lateinit var lic1: EditText
    private lateinit var lic2: EditText
    private lateinit var butt: Button
    private lateinit var buttSort: Button
    private lateinit var res: TextView
    private lateinit var reska: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt0 = findViewById(R.id.licz1)
        edt1 = findViewById(R.id.znak)
        edt2 = findViewById(R.id.licz2)
        lic1 = findViewById(R.id.l0)
        lic2 = findViewById(R.id.l1)
        butt = findViewById(R.id.add)
        buttSort = findViewById(R.id.sort)
        res = findViewById(R.id.liczres)
        reska = findViewById(R.id.reska)

        edt0.onFocusChangeListener = this
        edt1.onFocusChangeListener = this
        edt2.onFocusChangeListener = this

        butt.setOnClickListener(this)
        buttSort.setOnClickListener(this)
    }

    override fun onFocusChange(p0: View?, p1: Boolean) { checkInput() }

    override fun onClick(v: View) {
        when(v.id)
        {
            R.id.add -> res.text = calc().toString()
            R.id.sort -> reska.text = "Min: " + sort().minOrNull().toString() + " Max: " + sort().maxOrNull().toString() + " AVG: " + sort().average().toString()
        }
    }

    private fun sort(): List<Float> {
        return lic2.text.split(", ").map { it.trim().toFloat() }
    }

    private fun calc(): Float{
        return when (edt1.text.toString()) {
            "+" -> add()
            "-" -> sub()
            "*" -> mult()
            "/" -> div()
            else -> 404F
        }
    }

    private fun checkInput() {
        if (!edt1.text.toString().contains("+") && !edt1.text.toString().contains("-") && !edt1.text.toString().contains("*") && !edt1.text.toString().contains("/")) {
            "math sign should be one of: +, -, *, /".also { res.text = it }
            butt.visibility = Button.INVISIBLE
        } else {
            if (edt0.text.isNotEmpty() && edt2.text.isNotEmpty()) {
                if (!edt0.text.toString().contains(" ") && !edt2.text.toString()
                        .contains(" ") && !Pattern.matches(
                        "[a-zA-Z]+",
                        edt0.text
                    ) && !Pattern.matches("[a-zA-Z]+", edt2.text) && !Pattern.matches(
                        "[а-яА-Я]+",
                        edt0.text
                    ) && !Pattern.matches("[а-яА-Я]+", edt2.text)
                ) butt.visibility = Button.VISIBLE else butt.visibility = Button.INVISIBLE
            } else butt.visibility = Button.INVISIBLE
        }
    }

    private fun add(): Float {
        val l1 = findViewById<EditText>(R.id.licz1)
        val l2 = findViewById<EditText>(R.id.licz2)
        val result = findViewById<TextView>(R.id.liczres)
        return l1.text.toString().toFloat() + l2.text.toString().toFloat()
    }

    private fun sub(): Float {
        val l1 = findViewById<EditText>(R.id.licz1)
        val l2 = findViewById<EditText>(R.id.licz2)
        return l1.text.toString().toFloat() - l2.text.toString().toFloat()
    }

    private fun mult(): Float {
        val l1 = findViewById<EditText>(R.id.licz1)
        val l2 = findViewById<EditText>(R.id.licz2)
        val result = findViewById<TextView>(R.id.liczres)
        return l1.text.toString().toFloat() * l2.text.toString().toFloat()
    }

    private fun div(): Float {
        val l1 = findViewById<EditText>(R.id.licz1)
        val l2 = findViewById<EditText>(R.id.licz2)
        val result = findViewById<TextView>(R.id.liczres)
        if (l2.text.toString().toInt() == 0) {
            "Cant div on 0".also { result.text = it }
            return 404F
        }
        return l1.text.toString().toFloat() / l2.text.toString().toFloat()
    }
}