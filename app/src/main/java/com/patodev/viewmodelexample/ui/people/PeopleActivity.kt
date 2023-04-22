package com.patodev.viewmodelexample.ui.people

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.patodev.viewmodelexample.R
import com.patodev.viewmodelexample.databinding.ActivityPeopleBinding
import com.patodev.viewmodelexample.ui.superheroes.ProvideSuperheroes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleActivity : AppCompatActivity() {
    private val TAG = this::class.java.simpleName
    companion object{
        fun create(context: Context):Intent = Intent(context, PeopleActivity::class.java)
    }
    private lateinit var binding: ActivityPeopleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}