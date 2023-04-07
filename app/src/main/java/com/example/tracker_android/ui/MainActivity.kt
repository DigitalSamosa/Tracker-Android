package com.example.tracker_android.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.tracker_android.R
import com.example.tracker_android.util.BuildConfig

class MainActivity : FragmentActivity() {
    private val buildConfig = BuildConfig
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            // disabled for testing
//            buildConfig.checkFirstRun(supportFragmentManager, this)
            supportFragmentManager.beginTransaction().replace(R.id.container, WelcomeFragment.newInstance()).commitNow()
        }
        actionBar?.hide()
    }
}