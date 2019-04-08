package com.joohernandes.mvvmstudy.useCase

import com.joohernandes.mvvmstudy.repository.DataService
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.functions.Consumer
import org.jetbrains.anko.Android

class SearchPokemon (private val repository : DataService) {

    fun getPokemonSprite(pokemonName : String) : Single<String>  =
         repository.findPokemon(pokemonName)
            .map { it.sprites.frontDefault }
}