package com.example.contact_minorproject

import androidx.lifecycle.LiveData

class ContactRepository (val dao : ContactDao) {
    fun getAllContact() : LiveData<List<Contacts>> {
        return dao.getAllContacts()
    }
    fun insertContact(contact : Contacts) {
        dao.insertContact(contact)
    }
}