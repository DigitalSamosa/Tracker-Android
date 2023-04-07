package com.example.tracker_android.util

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.example.tracker_android.BuildConfig
import com.example.tracker_android.R
import com.example.tracker_android.ui.WelcomeBackFragment
import com.example.tracker_android.ui.WelcomeFragment

object BuildConfig {
    val currentVersionCode = BuildConfig.VERSION_CODE

    internal fun checkFirstRun(supportFragmentManager: FragmentManager, context: Context) {
        val sharedPrefs = context.getSharedPreferences(Constants.SHARED_PREF, Context.MODE_PRIVATE)
        val savedVersionCode = sharedPrefs.getInt(Constants.PREF_VERSION_CODE_KEY, Constants.PREF_VERSION_DOESNT_EXIST)

        if (currentVersionCode == savedVersionCode) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WelcomeBackFragment.newInstance())
                .commitNow()
        } else if (savedVersionCode == Constants.PREF_VERSION_DOESNT_EXIST) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WelcomeFragment.newInstance())
                .commitNow()
        } else if (currentVersionCode > savedVersionCode) {
            // TODO Upgrade
        }
        sharedPrefs.edit().putInt(Constants.PREF_VERSION_CODE_KEY, currentVersionCode).apply()
    }
}