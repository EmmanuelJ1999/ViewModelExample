package com.patodev.viewmodelexample.domain.usecases

import com.patodev.viewmodelexample.data.database.entities.toDB
import com.patodev.viewmodelexample.data.repositories.PeopleRepository
import com.patodev.viewmodelexample.domain.entities.People
import javax.inject.Inject

class AddNewPeople @Inject constructor(
    private val repository: PeopleRepository
) {
    suspend operator fun invoke(people:People){
        repository.insertPeople(people.toDB())
    }
}