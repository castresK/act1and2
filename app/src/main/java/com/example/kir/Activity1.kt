package com.example.kir

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Activity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act1)

        val listView: ListView = findViewById(R.id.listView)
        val countries = listOf(
            "Philippines", "United States", "Canada", "Australia", "Japan",
            "South Korea", "China", "Germany", "United Kingdom", "France",
            "Italy", "India", "Russia", "Brazil", "Mexico", "Argentina",
            "Spain", "Turkey", "Saudi Arabia", "South Africa"
        )

        val adapter = ArrayAdapter(
            this,
            R.layout.list_item,
            R.id.textView,
            countries
        )
        listView.adapter = adapter

        val backButton: ImageButton = findViewById(R.id.imageButton)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
