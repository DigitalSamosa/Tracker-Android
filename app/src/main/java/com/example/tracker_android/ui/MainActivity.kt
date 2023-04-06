package com.example.tracker_android.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.tracker_android.R
import com.example.tracker_android.util.BuildConfig

class MainActivity : FragmentActivity() {
    private val buildConfig = BuildConfig
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            buildConfig.checkFirstRun(supportFragmentManager, this)
        }
        actionBar?.hide()
    }
}