package com.example.contact_minorproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    val repository : ContactRepository
    init {
        val dao = ContactDatabase.getDatabaseInstance(application).contactDao()
        repository = ContactRepository(dao)
    }

    fun insertContact(contact : Contacts){
        repository.insertContact(contact)
    }
    fun getAllContacts() : LiveData<List<Contacts>> = repository.getAllContact()
}