package com.patodev.viewmodelexample.domain.entities

import com.patodev.viewmodelexample.data.database.entities.PeopleDB

data class People(
    val firstName:String,
    val lastName:String,
    val age:Int
)

fun PeopleDB.toDomain() = People(firstName, lastName, age)
