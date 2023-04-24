package com.patodev.viewmodelexample.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) :ViewModel(){

    private val _color = MutableLiveData<Int>()
    val color = _color

    fun randomColor(context: Context){
        _color.apply { value =  ProvideColor().getRandomColor(context)}
    }
}