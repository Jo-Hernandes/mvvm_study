package com.joohernandes.mvvmstudy.dependencyInjection

import com.joohernandes.mvvmstudy.dependencyInjection.DataSourceProperties.URL
import com.joohernandes.mvvmstudy.repository.DataService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val dataSource = module{

    single { createWebService<DataService>("https://pokeapi.co/api/v2/") }

}

object DataSourceProperties {
    const val URL = "SERVER_URL"
}

inline fun <reified T> createWebService(url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
    return retrofit.create(T::class.java)
}
