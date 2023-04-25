package com.example.appinnovationproject.models.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appinnovationproject.models.data.Localdata

@Database(entities = [Localdata::class], version = 1, exportSchema = false)
abstract class LocalDatabase:RoomDatabase() {

    abstract fun Localdao():LocalDao

    companion object{

        @Volatile
        private var INSTANCE:LocalDatabase? = null

        fun getinstance(context: Context):LocalDatabase{
            val tempinstance = INSTANCE
            if(tempinstance!=null){
                return tempinstance
            }else{
                synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        LocalDatabase::class.java,
                        "Mydatabase"
                    ).build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
}