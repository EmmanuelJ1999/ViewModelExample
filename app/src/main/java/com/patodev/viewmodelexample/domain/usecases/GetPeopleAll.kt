package com.patodev.viewmodelexample.domain.usecases

import com.patodev.viewmodelexample.data.repositories.PeopleRepository
import com.patodev.viewmodelexample.domain.entities.toDomain
import javax.inject.Inject

class GetPeopleAll @Inject constructor(
    private val repository: PeopleRepository
){
    suspend operator fun invoke() =
        repository.getPeopleAll().map { it.toDomain() }
}