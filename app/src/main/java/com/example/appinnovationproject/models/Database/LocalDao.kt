package com.example.appinnovationproject.models.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appinnovationproject.models.data.Localdata

@Dao
interface LocalDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertdata(data:Localdata)

    @Query("SELECT * FROM mytable")
     fun getalldata():LiveData<List<Localdata>>
}