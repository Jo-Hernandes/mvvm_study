package com.joohernandes.mvvmstudy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.joohernandes.mvvmstudy.R
import com.joohernandes.mvvmstudy.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject



class MainActivity : AppCompatActivity() {

    private val model : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.viewModel = model
        binding.executePendingBindings()
    }
}
