package com.patodev.viewmodelexample.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.patodev.viewmodelexample.data.database.entities.PeopleDB

@Dao
interface PeopleDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertPeople(people: PeopleDB)

    @Query("select * from People")
    suspend fun getPeopleAll():List<PeopleDB>
}