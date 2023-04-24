package com.patodev.viewmodelexample.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.patodev.viewmodelexample.domain.entities.People

@Entity(tableName = "People")
data class PeopleDB(
    @PrimaryKey
    @ColumnInfo(name = "Id")
    val id: Int? = null,
    @ColumnInfo(name = "FirstName")
    val firstName: String,
    @ColumnInfo(name = "LastName")
    val lastName: String,
    @ColumnInfo(name = "Age")
    val age: Int
)

fun People.toDB() = PeopleDB(firstName = firstName, lastName = lastName, age = age)
