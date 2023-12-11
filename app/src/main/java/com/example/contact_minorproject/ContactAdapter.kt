package com.example.contact_minorproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contact_minorproject.databinding.ContactLayoutBinding
import com.google.android.material.transition.Hold

class ContactAdapter(val list : List<Contacts>) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    class ViewHolder(val binding: ContactLayoutBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(
            ContactLayoutBinding.inflate(
                LayoutInflater.from(parent.context) , parent ,false
            )
        )
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.contactName.text = list[position].name
        holder.binding.contactNumber.text = list[position].number
    }

}