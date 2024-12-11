package com.example.kir

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


// Country Adapter
class CountryAdapter(private val context: Context, private val countries: List<Country>) : BaseAdapter() {

    override fun getCount(): Int {
        return countries.size
    }

    override fun getItem(position: Int): Any {
        return countries[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: CountryViewHolder

        if (convertView == null) {
            view =
                LayoutInflater.from(parent?.context).inflate(R.layout.item_country, parent, false)
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






