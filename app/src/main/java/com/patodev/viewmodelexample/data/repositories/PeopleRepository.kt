package com.patodev.viewmodelexample.data.repositories

import com.patodev.viewmodelexample.data.database.dao.PeopleDao
import com.patodev.viewmodelexample.data.database.entities.PeopleDB
import javax.inject.Inject

class PeopleRepository @Inject constructor(
    private val peopleDao: PeopleDao
){
    suspend fun insertPeople(people: PeopleDB){
        peopleDao.insertPeople(people)
    }

    suspend fun getPeopleAll() =
        peopleDao.getPeopleAll()
}