package com.patodev.viewmodelexample.ui.superheroes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patodev.viewmodelexample.domain.entities.SuperHero
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SuperHeroesViewModel @Inject constructor(

) :ViewModel(){
    private val TAG = this::class.java.simpleName
    private val _superhero = MutableLiveData<SuperHero>()
    val superHero = _superhero

    init{
        randomSuperhero()
    }

    fun randomSuperhero(){
        val hero = ProvideSuperheroes().getSuperheroes()
        Log.i(TAG, "Hero obtained: ${hero.name}")
        _superhero.apply { value = hero }
    }
}