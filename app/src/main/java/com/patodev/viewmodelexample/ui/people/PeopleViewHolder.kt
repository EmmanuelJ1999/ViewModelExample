package com.patodev.viewmodelexample.ui.people

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.patodev.viewmodelexample.databinding.ItemPeopleBinding
import com.patodev.viewmodelexample.domain.entities.People


class PeopleViewHolder(view:View) : RecyclerView.ViewHolder(view){
    private val binding = ItemPeopleBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun render(
        people: People,
        onClickListener:(People) -> Unit
    ){
        binding.tvCompleteName.text = "${people.firstName} ${people.lastName}"
        binding.tvAge.text = people.age.toString()

        itemView.setOnClickListener { onClickListener(people) }
    }
}