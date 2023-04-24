package com.patodev.viewmodelexample.ui.people

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.patodev.viewmodelexample.databinding.ActivityPeopleBinding
import com.patodev.viewmodelexample.domain.usecases.GetPeopleAll
import com.patodev.viewmodelexample.ui.people.info.PeopleInfoActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class PeopleActivity : AppCompatActivity() {
    private val TAG = this::class.java.simpleName
    companion object{
        fun create(context: Context):Intent = Intent(context, PeopleActivity::class.java)
    }
    private lateinit var binding: ActivityPeopleBinding
    @Inject lateinit var getPeopleAll: GetPeopleAll
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAdd.setOnClickListener { openPeopleInfoActivity() }
    }

    private fun initPeopleList() {
        lifecycleScope.launch {
            val peopleList = getPeopleAll()
            runOnUiThread{
                binding.rvPeople.layoutManager = LinearLayoutManager(this@PeopleActivity)
                binding.rvPeople.adapter = PeopleAdapter(peopleList){

                }
            }
        }
    }

    private fun openPeopleInfoActivity() {
        startActivity(PeopleInfoActivity.create(this))
    }

    override fun onResume() {
        super.onResume()
        initPeopleList()
    }

}