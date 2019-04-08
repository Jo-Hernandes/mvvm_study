package com.joohernandes.mvvmstudy.repository

import com.joohernandes.mvvmstudy.entity.PokemonModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface DataService {


    @GET("pokemon/{pokemon}")
    fun findPokemon(@Path("pokemon") pokemon : String) : Single<PokemonModel>


}