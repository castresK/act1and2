package com.example.kir

import android.content.Intent
import android.graphics.Color
import android.os.Bundle

import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class GroupMember(val name: String)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val welcomeTextView: TextView = findViewById(R.id.tvWelcome)

        val groupMembers = listOf(
            GroupMember("Jorose Po"),
            GroupMember("Maria Victoria Catabay"),
            GroupMember("Terrence Lappay"),
            GroupMember("James Laurence Rosario"),
            GroupMember("Kristine Castres",)
        )

        val welcomeMessage = "BSIT2-01 Activity\n Members:"
        welcomeTextView.text = welcomeMessage

        val groupListView: ListView = findViewById(R.id.groupListView)
        val adapter = GroupAdapter(this, groupMembers)
        groupListView.adapter = adapter

        // Activity1
        val btnToFirst: Button = findViewById(R.id.btnToFirst)
        btnToFirst.setBackgroundColor(Color.parseColor("#982B1C"))
        btnToFirst.setOnClickListener {
            val intent = Intent(this, Activity1::class.java)
            startActivity(intent)
        }

        // Activity2
        val btnToSecond: Button = findViewById(R.id.btnToSecond)
        btnToSecond.setBackgroundColor(Color.parseColor("#982B1C"))
        btnToSecond.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }
    }
}


