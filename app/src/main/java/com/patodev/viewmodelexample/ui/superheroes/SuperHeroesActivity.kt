package com.patodev.viewmodelexample.ui.superheroes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.patodev.viewmodelexample.R
import com.patodev.viewmodelexample.databinding.ActivitySuperHeroesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuperHeroesActivity : AppCompatActivity() {
    private val TAG = this::class.java.simpleName
    companion object {
        fun create(context: Context): Intent = Intent(context, SuperHeroesActivity::class.java)
    }
    private lateinit var binding: ActivitySuperHeroesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.layout.setOnClickListener { setHero() }
    }

    private fun setHero() {
        val hero = ProvideSuperheroes().getSuperheroes()
        Log.i(TAG, "Hero obtained: ${hero.name}")

        binding.tvName.text = hero.name
        binding.ivImage.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                hero.image
            )
        )
    }
}