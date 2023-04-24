package com.patodev.viewmodelexample.ui.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.patodev.viewmodelexample.R
import com.patodev.viewmodelexample.databinding.ActivityMainBinding
import com.patodev.viewmodelexample.domain.usecases.AddNewPeople
import com.patodev.viewmodelexample.ui.people.PeopleActivity
import com.patodev.viewmodelexample.ui.superheroes.SuperHeroesActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSuperheroes.setOnClickListener { openSuperHeroesActivity() }
        binding.btnPeople.setOnClickListener { openPeopleActivity() }
        binding.btnChangeColor.setOnClickListener { changeColor() }
    }

    private fun changeColor() {
        binding.layout.setBackgroundColor(ProvideColor().getRandomColor(this))
    }

    private fun openPeopleActivity() {
        startActivity(PeopleActivity.create(this))
    }

    private fun openSuperHeroesActivity() {
        startActivity(SuperHeroesActivity.create(this))
    }
}