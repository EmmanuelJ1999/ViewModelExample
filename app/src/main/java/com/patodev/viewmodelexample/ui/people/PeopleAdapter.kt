package com.patodev.viewmodelexample.ui.people

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patodev.viewmodelexample.R
import com.patodev.viewmodelexample.domain.entities.People

class PeopleAdapter(
    private val peopleList: List<People>,
    private val onClickListener:(People) -> Unit
) : RecyclerView.Adapter<PeopleViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PeopleViewHolder(layoutInflater.inflate(R.layout.item_people,parent,false))
    }

    override fun getItemCount(): Int = peopleList.size

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val item = peopleList[position]
        holder.render(item, onClickListener)
    }
}