package com.patodev.viewmodelexample.ui.superheroes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.patodev.viewmodelexample.R
import com.patodev.viewmodelexample.databinding.ActivitySuperHeroesBinding
import com.patodev.viewmodelexample.domain.entities.SuperHero
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuperHeroesActivity : AppCompatActivity() {
    private val TAG = this::class.java.simpleName
    companion object {
        fun create(context: Context): Intent = Intent(context, SuperHeroesActivity::class.java)
    }
    private lateinit var binding: ActivitySuperHeroesBinding
    private val viewmodel by viewModels<SuperHeroesViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.layout.setOnClickListener { viewmodel.randomSuperhero() }

        viewmodel.superHero.observe(this){
            setHero(it)
        }
    }

    private fun setHero(hero: SuperHero) {
        binding.tvName.text = hero.name
        binding.ivImage.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                hero.image
            )
        )
    }
}