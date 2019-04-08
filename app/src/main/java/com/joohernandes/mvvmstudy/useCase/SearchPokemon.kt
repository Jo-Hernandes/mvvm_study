package com.joohernandes.mvvmstudy.useCase

import com.joohernandes.mvvmstudy.repository.DataService
import io.reactivex.functions.Consumer

class SearchPokemon (private val repository : DataService) {


    fun getPokemonSprite(pokemonName : String, urlResponse : Consumer<String>, error : Consumer<Throwable>) {
        repository.findPokemon(pokemonName)
            .map { it.sprites.frontDefault }
            .subscribe(urlResponse, error)
    }

}