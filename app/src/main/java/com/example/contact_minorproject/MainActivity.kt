package com.example.contact_minorproject

import android.content.Intent
import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contact_minorproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: ContactViewModel
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       viewModel = ViewModelProvider(this)[ContactViewModel::class.java]
         binding.floatingActionButton.setOnClickListener{
             val intent  = Intent(this@MainActivity , ContactActivity::class.java)
             startActivity(intent)
         }
         viewModel.getAllContacts().observe(this , Observer {contact-> // contact = List<Contacts>
         binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
          binding.recyclerView.adapter = ContactAdapter(contact)

         })



    }
}


