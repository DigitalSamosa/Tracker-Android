package com.example.tracker_android.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.tracker_android.R
import com.example.tracker_android.controller.MainController
import com.example.tracker_android.util.BuildConfig
import com.example.tracker_android.util.FragmentHelper

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val fragmentHelper = FragmentHelper()

    private val buildConfig = BuildConfig
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
            // disabled for testing
//            buildConfig.checkFirstRun(supportFragmentManager, this)
//            fragmentHelper.showAndAddToBackStack(WelcomeBackFragment.newInstance())

        applicationContext?.let { viewModel.initializeController(it.applicationContext) }
        Log.d("dexter", "main activity")
        MainController.showWelcome()
        supportActionBar?.hide()
    }
}