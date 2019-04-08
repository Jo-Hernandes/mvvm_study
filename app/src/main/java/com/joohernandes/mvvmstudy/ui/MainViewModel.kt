package com.joohernandes.mvvmstudy.ui

import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joohernandes.mvvmstudy.useCase.SearchPokemon
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class MainViewModel (private val searchUseCase : SearchPokemon) : ViewModel () {

    private val textChangeSubject:PublishSubject<String> = PublishSubject.create<String>()
    val pokemonUrl : MutableLiveData<String> = MutableLiveData()

    init {
        queryChangeObserver().subscribe(consumeString())
    }

    fun onTextChanged(query: Editable) {
        if (query.isBlank()) {
            textChangeSubject.onNext("")
        } else {
            textChangeSubject.onNext(query.toString())
        }
    }

    private fun queryChangeObserver() : Observable<String> {
        return textChangeSubject.debounce(200, TimeUnit.MILLISECONDS).distinctUntilChanged()
    }

    private fun consumeString () : Consumer<String> = Consumer{
        searchUseCase.getPokemonSprite(it).subscribe(pokemonUrl::postValue) { e -> e.printStackTrace()}
    }

}