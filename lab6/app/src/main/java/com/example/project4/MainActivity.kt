package com.example.project4

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.helper.widget.MotionEffect
import com.example.project4.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var bdelete: Button
    private lateinit var bshow: Button

    private lateinit var tView: TextView

    private lateinit var binding: ActivityMainBinding

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUp1.setOnClickListener(this)

        bdelete = findViewById(R.id.btndelete)
        bdelete.setOnClickListener {
            deleteuser()
        }

        tView = findViewById(R.id.textView)

        bshow = findViewById(R.id.btnbshow)
        bshow.setOnClickListener {
            showUser()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {

            binding.signUp1.id -> {
                startActivity(Intent(this, RegisterScreen::class.java))

            }


        }
    }
    private fun deleteuser() {
        val user = FirebaseAuth.getInstance().currentUser

        user?.delete()?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, getString(R.string.User_account_deleted), Toast.LENGTH_SHORT).show()

            }
        }
    }
    private fun showUser(){
        val user = FirebaseAuth.getInstance().currentUser
        user?.let {
            for (profile in it.providerData) {
                val name = profile.displayName
                val email1 = profile.email
                tView.text = email1.toString()
            }

        }
    }


}