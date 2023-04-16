package com.example.tracker_android.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.tracker_android.R
import com.example.tracker_android.controller.MainController

internal class FragmentHostActivity : AppCompatActivity() {

    private lateinit var mainController: MainController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.setupForAccessibility()
        setContentView(R.layout.activity_fragment_host)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_BEHIND
        mainController = MainController.getController()
        mainController.activityReady(this)
        Log.d("dexter", "fragment host")
    }

    public override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    private fun FragmentManager.setupForAccessibility() {
        addOnBackStackChangedListener {
            if (isFinishing || fragments.isEmpty()) {
                return@addOnBackStackChangedListener
            }
            val lastFragmentWithView = try {
                fragments.last { it.view != null }
            } catch (e: NoSuchElementException) {
                null
            }
            for (fragment in fragments) {
                if (fragment == lastFragmentWithView) {
                    fragment.view?.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES
                } else {
                    fragment.view?.importantForAccessibility =
                        View.IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS
                }
            }
        }
    }
}
