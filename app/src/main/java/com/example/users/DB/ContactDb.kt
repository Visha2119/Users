package com.example.users.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.users.model.RepositoriesList
import com.example.users.model.TypeConverterData


@Database(entities = [RepositoriesList::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverterData::class)
abstract class ContactDb: RoomDatabase(){

    abstract fun  getContactDao():ContactDao

    companion object{
        @Volatile
        private var INSTANCE:ContactDb?=null

        fun getInstance(context: Context):ContactDb{
            synchronized(this){
                var instance= INSTANCE

                if(instance==null){
                    instance= Room.databaseBuilder(context.applicationContext,ContactDb::class.java,"Contact_Database")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE=instance
                }
                return instance
            }
        }
    }
}