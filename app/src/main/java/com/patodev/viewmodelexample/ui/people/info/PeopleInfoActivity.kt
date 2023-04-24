package com.patodev.viewmodelexample.ui.people.info

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.patodev.viewmodelexample.databinding.ActivityPeopleInfoBinding
import com.patodev.viewmodelexample.domain.entities.People
import com.patodev.viewmodelexample.domain.usecases.AddNewPeople
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.Delegates

@AndroidEntryPoint
class PeopleInfoActivity : AppCompatActivity() {
    companion object{
        private var edit: Boolean = false
        fun create(context: Context, edit: Boolean = false): Intent {
            this.edit = edit
            return Intent(context, PeopleInfoActivity::class.java)
        }
    }

    private val TAG = this::class.java
    private lateinit var binding : ActivityPeopleInfoBinding
    @Inject lateinit var addNewPeople: AddNewPeople

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPeopleInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rsAge.addOnChangeListener {
                slider, value, fromUser ->
            binding.tvAgeValue.text = value.toInt().toString()
        }

        binding.btnSave.setOnClickListener{save()}
    }

    private fun save() {
        val people = People(
            binding.etFirstName.text.toString(),
            binding.etLastName.text.toString(),
            binding.tvAgeValue.text.toString().toInt()
        )

        lifecycleScope.launch {
            addNewPeople(people)
            runOnUiThread{
                Toast.makeText(this@PeopleInfoActivity, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }


}