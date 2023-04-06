package com.example.tracker_android.controller

import androidx.fragment.app.FragmentManager
import com.example.tracker_android.ui.WelcomeFragment

class MainController {
    internal lateinit var parentFragmentManager: FragmentManager

    fun showWelcomeFragment() {
//        val welcomeFragment = WelcomeFragment.newInstance()
//        parentFragmentManager = welcomeFragment.parentFragmentManager
//        if (parentFragmentManager.backStackEntryCount > 1) {
//            parentFragmentManager.popBackStackImmediate()
//
//        } else {
//            parentFragmentManager.beginTransaction().show(welcomeFragment).addToBackStack(null).commit()
//
//        }
        val welcomeFragment = WelcomeFragment.newInstance()
        welcomeFragment.arguments = welcomeFragment.activity?.intent?.extras
    }
}