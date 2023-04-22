package com.patodev.viewmodelexample.ui.superheroes

import com.patodev.viewmodelexample.R
import com.patodev.viewmodelexample.domain.entities.SuperHero
import kotlin.random.Random

class ProvideSuperheroes {

    fun getSuperheroes(): SuperHero =
        when (Random.nextInt(0, 9)) {
            0 -> SuperHero("Batman", R.drawable.batman)
            1 -> SuperHero("Superman", R.drawable.superman)
            2 -> SuperHero("Flash", R.drawable.flash)
            3 -> SuperHero("Red Hood", R.drawable.red_hood)
            4 -> SuperHero("Wonder Woman", R.drawable.wonder_woman)
            5 -> SuperHero("Batgirl", R.drawable.batgirl)
            6 -> SuperHero("Aquaman", R.drawable.aquaman)
            7 -> SuperHero("Green Lantern", R.drawable.green_lantern)
            8 -> SuperHero("Nightwing", R.drawable.nightwing)
            9 -> SuperHero("Harley Quinn", R.drawable.harley_quinn)
            else -> SuperHero("Varios", R.drawable.varios)
        }
}