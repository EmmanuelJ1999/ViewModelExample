package com.patodev.viewmodelexample.ui.people.info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patodev.viewmodelexample.domain.entities.People
import com.patodev.viewmodelexample.domain.usecases.AddNewPeople
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleInfoViewModel @Inject constructor(
    private val addNewPeople: AddNewPeople
) :ViewModel(){

    fun savePeople(people: People){
        viewModelScope.launch {
            addNewPeople(people)
        }
    }
}