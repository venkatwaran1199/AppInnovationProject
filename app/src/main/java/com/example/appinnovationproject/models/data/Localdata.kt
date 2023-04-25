package com.example.appinnovationproject.models.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "mytable")
data class Localdata(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var name:String,
    var age:String,
    var gender:String,
    var languages:String
)
