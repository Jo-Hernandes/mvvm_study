package com.joohernandes.mvvmstudy.ui

import android.text.Editable
import android.util.Log
import androidx.lifecycle.ViewModel
import com.joohernandes.mvvmstudy.useCase.SearchPokemon
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class MainViewModel (private val searchUseCase : SearchPokemon) : ViewModel () {

    private val textChangeSubject:PublishSubject<String> = PublishSubject.create<String>()

    init {
        queryChangeObserver().subscribe(consumeString())
    }

    fun onTextChanged(query: Editable) {
        if (query.isNullOrBlank()) {
            textChangeSubject.onNext("")
        } else {
            textChangeSubject.onNext(query.toString())
        }
    }

    fun queryChangeObserver() : Observable<String> {
        return textChangeSubject.debounce(200, TimeUnit.MILLISECONDS).distinctUntilChanged()
    }

    fun consumeString () : Consumer<String> = Consumer{
        searchUseCase.getPokemonSprite(it, consumePokemonUrl(), consumeException())
    }

    fun consumePokemonUrl () : Consumer<String> = Consumer {
        Log.d("POKEMON ULR ", it)
    }

    fun consumeException () : Consumer<Throwable> = Consumer {  }
}