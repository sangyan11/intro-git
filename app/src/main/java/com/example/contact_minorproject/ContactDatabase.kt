package com.example.contact_minorproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contacts::class] , version = 1 , exportSchema = false)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDao
    companion object {
        @Volatile
        var INSTANCE: ContactDatabase? = null

        // Singleton instance of the database
        fun getDatabaseInstance(context: Context): ContactDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            // Synchronized block to make sure that
            // only one instance of the database is created
            synchronized(this) {
                val roomDatabaseInstance =
                    Room.databaseBuilder(context, ContactDatabase::class.java, "Contacts")
                        .allowMainThreadQueries().build()
                INSTANCE = roomDatabaseInstance
                return roomDatabaseInstance
            }
        }
    }
}