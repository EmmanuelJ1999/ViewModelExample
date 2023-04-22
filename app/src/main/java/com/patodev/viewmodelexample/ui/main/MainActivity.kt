package com.patodev.viewmodelexample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.patodev.viewmodelexample.databinding.ActivityMainBinding
import com.patodev.viewmodelexample.ui.people.PeopleActivity
import com.patodev.viewmodelexample.ui.superheroes.SuperHeroesActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSuperheroes.setOnClickListener { openSuperHeroesActivity() }
        binding.btnPeople.setOnClickListener { openPeopleActivity() }
    }

    private fun openPeopleActivity() {
        startActivity(PeopleActivity.create(this))
    }

    private fun openSuperHeroesActivity() {
        startActivity(SuperHeroesActivity.create(this))
    }
}