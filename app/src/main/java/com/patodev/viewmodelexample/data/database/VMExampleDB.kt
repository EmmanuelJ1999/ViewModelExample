package com.patodev.viewmodelexample.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.patodev.viewmodelexample.data.database.dao.PeopleDao
import com.patodev.viewmodelexample.data.database.entities.PeopleDB

@Database(entities = [PeopleDB::class], version = 1)
abstract class VMExampleDB: RoomDatabase() {
    abstract val peopleDao: PeopleDao
}