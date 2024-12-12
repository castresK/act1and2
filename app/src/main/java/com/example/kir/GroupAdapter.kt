package com.example.kir

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class GroupAdapter(context: Context, private val members: List<GroupMember>) : ArrayAdapter<GroupMember>(context, R.layout.group_list, members) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.group_list, parent, false)

        val memberNameTextView: TextView = view.findViewById(R.id.memberName)

        val member = members[position]

        memberNameTextView.text = "${member.name}"

        return view
    }
}
