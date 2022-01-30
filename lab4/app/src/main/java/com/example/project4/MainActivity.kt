package com.example.project4

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import com.example.project4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login1.setOnClickListener(this)
        binding.signUp1.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            binding.login1.id -> {
                startActivity(Intent(this, LogScreen::class.java))
                //CardList.addRandomConsultationCard()
                //val myDataset = CardList.loadConsultationCards()
                //binding.recyclerView.adapter = ItemAdapter(this, myDataset)
                //binding.recyclerView.setHasFixedSize(true)
            }
            binding.signUp1.id -> {
                startActivity(Intent(this, RegisterScreen::class.java))
                //CardList.addRandomConsultationCard()
                //val myDataset = CardList.loadConsultationCards()
                //binding.recyclerView.adapter = ItemAdapter(this, myDataset)
                //binding.recyclerView.setHasFixedSize(true)
            }


        }
    }


}