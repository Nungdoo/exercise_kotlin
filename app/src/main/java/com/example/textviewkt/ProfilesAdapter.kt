package com.example.textviewkt

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class ProfilesAdapter(val profileList: ArrayList<Profiles>) : RecyclerView.Adapter<ProfilesAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfilesAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos : Int = adapterPosition
                val profile : Profiles = profileList.get(curPos)
                Toast.makeText(parent.context, "이름 : ${profile.name}", Toast.LENGTH_SHORT).show()
                Log.d("로그로그", "Log Log")
            }
        }
    }

    override fun onBindViewHolder(holder: ProfilesAdapter.CustomViewHolder, position: Int) {
        holder.gender.setImageResource(profileList.get(position).gender)
        holder.name.text = profileList.get(position).name
        holder.age.text = profileList.get(position).age.toString()
        holder.job.text = profileList.get(position).job

    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gender = itemView.findViewById<ImageView>(R.id.iv_profiles)
        val name = itemView.findViewById<TextView>(R.id.tv_names)
        val age = itemView.findViewById<TextView>(R.id.tv_ages)
        val job = itemView.findViewById<TextView>(R.id.tv_jobs)
    }
}