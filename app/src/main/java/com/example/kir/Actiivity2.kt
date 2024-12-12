package com.example.kir

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.BaseAdapter
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

data class Country(
    val flagResId: Int,
    val name: String,
    val capital: String,
)

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act2)

        // Set up ListView
        val listView: ListView = findViewById(R.id.listView)
        val countries = listOf(
            Country(R.drawable.ph_flag, "Philippines", "Manila"),
            Country(R.drawable.us_flag, "United States", "Washington, D.C."),
            Country(R.drawable.canada_flag, "Canada", "Ottawa"),
            Country(R.drawable.uk_flag, "United Kingdom", "London"),
            Country(R.drawable.germany_flag, "Germany", "Berlin"),
            Country(R.drawable.france_flag, "France", "Paris"),
            Country(R.drawable.australia_flag, "Australia", "Canberra"),
            Country(R.drawable.japan_flag, "Japan", "Tokyo"),
            Country(R.drawable.india_flag, "India", "New Delhi"),
            Country(R.drawable.brazil_flag, "Brazil", "Brasilia"),
            Country(R.drawable.south_korea_flag, "South Korea", "Seoul"),
            Country(R.drawable.russia_flag, "Russia", "Moscow"),
            Country(R.drawable.italy_flag, "Italy", "Rome"),
            Country(R.drawable.spain_flag, "Spain", "Madrid"),
            Country(R.drawable.china_flag, "China", "Beijing"),
            Country(R.drawable.mexico_flag, "Mexico", "Mexico City"),
            Country(R.drawable.south_africa_flag, "South Africa", "Pretoria"),
            Country(R.drawable.nigeria_flag, "Netherlands", "Amsterdam"),
            Country(R.drawable.argentina_flag, "Argentina", "Buenos Aires"),
            Country(R.drawable.egypt_flag, "Egypt", "Cairo")
        )

        val adapter = CountryAdapter(countries)
        listView.adapter = adapter

        //  back button
        val backButton: ImageButton = findViewById(R.id.imageButton)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    // ListView Adapter
    class CountryAdapter(private val countries: List<Country>) : BaseAdapter() {

        override fun getCount(): Int = countries.size

        override fun getItem(position: Int): Any = countries[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view: View
            val holder: CountryViewHolder

            if (convertView == null) {
                view = LayoutInflater.from(parent?.context).inflate(R.layout.item_country, parent, false)
                holder = CountryViewHolder(view)
                view.tag = holder
            } else {
                view = convertView
                holder = view.tag as CountryViewHolder
            }

            val country = countries[position]
            holder.flagImageView.setImageResource(country.flagResId)
            holder.nameTextView.text = country.name
            holder.capitalTextView.text = country.capital

            return view
        }

        private class CountryViewHolder(view: View) {
            val flagImageView: ImageView = view.findViewById(R.id.ivFlag)
            val nameTextView: TextView = view.findViewById(R.id.tvCountryName)
            val capitalTextView: TextView = view.findViewById(R.id.tvCapital)
        }
    }
}
