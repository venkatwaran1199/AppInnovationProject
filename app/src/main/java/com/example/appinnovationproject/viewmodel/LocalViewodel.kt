package com.example.appinnovationproject.viewmodel

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.appinnovationproject.models.Database.LocalDatabase
import com.example.appinnovationproject.models.data.Localdata
import com.example.appinnovationproject.models.repository.LocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate

class LocalViewodel(application: Application):AndroidViewModel(application) {

    private val Localdao = LocalDatabase.getinstance(application.applicationContext).Localdao()

    private val repository = LocalRepository(Localdao)

    val getalldata:LiveData<List<Localdata>> = repository.getalldata

    fun insertdata(mydata:Localdata){
        viewModelScope.launch(Dispatchers.IO){
            Log.d(TAG, "insertdata: $mydata")
            repository.insertdata(mydata)
        }
    }
}