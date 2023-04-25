package com.example.appinnovationproject.models.repository

import androidx.lifecycle.LiveData
import com.example.appinnovationproject.models.Database.LocalDao
import com.example.appinnovationproject.models.Database.LocalDatabase
import com.example.appinnovationproject.models.data.Localdata

class LocalRepository(private val Localdao:LocalDao) {

    val getalldata : LiveData<List<Localdata>>
    get() = Localdao.getalldata()

    suspend fun insertdata(mydata:Localdata){
        Localdao.insertdata(mydata)
    }
}