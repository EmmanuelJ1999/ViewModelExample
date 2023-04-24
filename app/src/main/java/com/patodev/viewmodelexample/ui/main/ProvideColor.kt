package com.patodev.viewmodelexample.ui.main

import android.content.Context
import androidx.core.content.ContextCompat
import com.patodev.viewmodelexample.R
import kotlin.random.Random

class ProvideColor {
    fun getRandomColor(context:Context):Int =
        when(Random.nextInt(0,6)){
            0-> ContextCompat.getColor(context, R.color.black)
            1-> ContextCompat.getColor(context, R.color.white)
            2-> ContextCompat.getColor(context, R.color.green)
            3-> ContextCompat.getColor(context, R.color.blue)
            4-> ContextCompat.getColor(context, R.color.yellow)
            5-> ContextCompat.getColor(context, R.color.orange)
            6-> ContextCompat.getColor(context, R.color.pink)
            else -> ContextCompat.getColor(context, R.color.black)
        }
}