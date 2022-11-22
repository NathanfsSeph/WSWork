package com.nathan.wswork.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nathan.wswork.data.model.User

@Database(entities = [User::class], version = 1)
abstract class WSWDatabase : RoomDatabase(){

    abstract fun userDao() : UserDao

    companion object {
        @Volatile
        private var INSTANCE: WSWDatabase? = null
        fun getInstance(context: Context): WSWDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WSWDatabase::class.java,
                        "wsw_database"
                    ).build()
                }
                return instance
            }
        }
    }
}