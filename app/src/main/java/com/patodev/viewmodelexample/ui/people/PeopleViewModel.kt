package com.patodev.viewmodelexample.ui.people

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patodev.viewmodelexample.domain.entities.People
import com.patodev.viewmodelexample.domain.usecases.GetPeopleAll
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val getPeopleAll: GetPeopleAll
) :ViewModel(){
    private val _people = MutableLiveData<List<People>>()
    val people = _people

    init {
        updatePeopleList()
    }

    fun updatePeopleList(){
        viewModelScope.launch {
            val peopleList = getPeopleAll()
            _people.apply { value = peopleList }
        }
    }
}