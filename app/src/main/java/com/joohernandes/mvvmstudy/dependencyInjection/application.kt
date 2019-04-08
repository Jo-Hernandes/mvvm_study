package com.joohernandes.mvvmstudy.dependencyInjection

import com.joohernandes.mvvmstudy.repository.DataService
import com.joohernandes.mvvmstudy.ui.MainViewModel
import com.joohernandes.mvvmstudy.useCase.SearchPokemon
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



val applicationModule = module {

    single { SearchPokemon(get() as DataService) }
    viewModel { MainViewModel(get()) }
}