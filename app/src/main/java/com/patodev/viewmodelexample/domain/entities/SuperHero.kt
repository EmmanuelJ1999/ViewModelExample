package com.patodev.viewmodelexample.domain.entities

import androidx.annotation.DrawableRes

data class SuperHero(
    val name:String,
    @DrawableRes val image: Int
)
