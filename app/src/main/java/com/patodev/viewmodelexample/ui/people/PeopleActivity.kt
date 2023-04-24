package com.patodev.viewmodelexample.ui.people

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.patodev.viewmodelexample.databinding.ActivityPeopleBinding
import com.patodev.viewmodelexample.domain.entities.People
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
    private val viewModel by viewModels<PeopleViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAdd.setOnClickListener { openPeopleInfoActivity() }

        viewModel.people.observe(this){
            initPeopleList(it)
        }
    }

    private fun initPeopleList(peopleList: List<People>) {
        binding.rvPeople.layoutManager = LinearLayoutManager(this)
        binding.rvPeople.adapter = PeopleAdapter(peopleList){

        }
    }

    private fun openPeopleInfoActivity() {
        startActivity(PeopleInfoActivity.create(this))
    }

    override fun onResume() {
        super.onResume()
        viewModel.updatePeopleList()
    }

}