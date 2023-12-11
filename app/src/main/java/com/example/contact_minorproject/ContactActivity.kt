package com.example.contact_minorproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.contact_minorproject.databinding.ActivityContactBinding

class ContactActivity : AppCompatActivity() {
    private lateinit var binding : ActivityContactBinding
    private lateinit var viewModel: ContactViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[ContactViewModel::class.java]
        binding.save.setOnClickListener{
            val name = binding.etName.text.toString()
            val number = binding.etNumber.text.toString()
            val  contact = Contacts(null , name , number)
              viewModel.insertContact(contact)
            val intent = Intent(this@ContactActivity , MainActivity::class.java)
            startActivity(intent)
            // open new Activity
        }
    }
}