package com.example.project4

import android.content.Intent
import android.app.AlertDialog
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.project4.adapter.ItemAdapter
import com.example.project4.databinding.ActivityMainBinding
import com.example.project4.databinding.ChooseTimeBinding
import com.example.project4.databinding.ChooseWhereBinding
import com.example.project4.floatMenu.Licznik
import com.example.project4.model.CardList

class ChooseTime : AppCompatActivity(), View.OnClickListener {

    private lateinit var bindingCTB: ChooseTimeBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingCTB = ChooseTimeBinding.inflate(layoutInflater)
        setContentView(bindingCTB.root)

        bindingCTB.homeButton.setOnClickListener(this)
        bindingCTB.addButton.setOnClickListener(this)
        bindingCTB.buttonCall.setOnClickListener(this)

        registerForContextMenu(bindingCTB.buttonOpenMenu)
    }

    override fun onClick(v: View) {
        when (v.id) {
            bindingCTB.homeButton.id -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
            bindingCTB.addButton.id -> {
                CardList.addRandomConsultationCard()
                startActivity(Intent(this, MainActivity::class.java))
            }
            bindingCTB.buttonCall.id -> {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:1120")
                startActivity(intent)
            }
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo? ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.floating_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> Toast.makeText(this,getString(R.string.profil), Toast.LENGTH_LONG).show()
            R.id.item2 -> startActivity(Intent(this, LogScreen::class.java))
            R.id.item3 -> chooseThemeDialog()
        }
        return super.onContextItemSelected(item)
    }
    private fun chooseThemeDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setSingleChoiceItems(arrayOf("Light","Dark","System default"), Licznik.checkedItem) { dialog, which ->
            when (which) {
                0 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                2 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
            Licznik.checkedItem = which
            delegate.applyDayNight()
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
}