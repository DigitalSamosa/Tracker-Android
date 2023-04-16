package com.example.tracker_android.controller

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.Lifecycle
import com.example.tracker_android.ui.FragmentHostActivity
import com.example.tracker_android.ui.HomePageFragment
import com.example.tracker_android.ui.WelcomeFragment
import com.example.tracker_android.util.Constants
import com.example.tracker_android.util.FragmentHelper
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

@SuppressLint("StaticFieldLeak")
object MainController {
    internal lateinit var fragmentHostActivity: FragmentHostActivity
    internal lateinit var welcomeFragment: WelcomeFragment
    internal lateinit var homePageFragment: HomePageFragment
    internal lateinit var context: Context
    internal lateinit var waitForActivity: CancellableContinuation<FragmentHostActivity>
    internal lateinit var waitForWelcomeFragment: CancellableContinuation<WelcomeFragment>
    internal lateinit var waitForHomePageFragment: CancellableContinuation<HomePageFragment>
    internal lateinit var sharedPrefs: SharedPreferences

    private val fragmentHelper = FragmentHelper()

    internal fun initialize(
        context: Context,
    ): MainController {
        this.context = if (context is Application) {
            context
        } else {
            context.applicationContext as Application
        }
        sharedPrefs = context.getSharedPreferences(Constants.SHARED_PREF, Context.MODE_PRIVATE)
        return this
    }

    internal fun getController(): MainController {
        return this
    }

    internal fun welcomeFragmentReady(activity: WelcomeFragment) {
        this.welcomeFragment = activity
        if (::waitForWelcomeFragment.isInitialized && !waitForWelcomeFragment.isCompleted) {
            waitForWelcomeFragment.resume(activity)
        }
    }

    internal suspend fun startActivity(): FragmentHostActivity {
        if (!::fragmentHostActivity.isInitialized || fragmentHostActivity.lifecycle.currentState != Lifecycle.State.RESUMED) {
            fragmentHostActivity = suspendCancellableCoroutine {
                waitForActivity = it
                fragmentHelper.startFragmentHostActivity()
            }
        }
        return fragmentHostActivity
    }

    internal suspend fun startWelcomeFragment(): WelcomeFragment {
        if (!::welcomeFragment.isInitialized || welcomeFragment.lifecycle.currentState != Lifecycle.State.RESUMED) {
            welcomeFragment = suspendCancellableCoroutine {
                waitForWelcomeFragment = it
                fragmentHelper.showAndAddToBackStack(WelcomeFragment.newInstance())
            }
        }
        return welcomeFragment
    }

    internal suspend fun startHomePageFragment(): HomePageFragment {
        if (!::homePageFragment.isInitialized || homePageFragment.lifecycle.currentState != Lifecycle.State.RESUMED) {
            homePageFragment = suspendCancellableCoroutine {
                waitForHomePageFragment = it
                fragmentHelper.showAndAddToBackStack(HomePageFragment.newInstance(), animEnter = android.R.anim.fade_in)
            }
        }
        return homePageFragment
    }

    internal fun showWelcome() {
        fragmentHelper.showWelcomeFragment(WelcomeFragment.newInstance())
    }

    internal fun showHomePage() {
        fragmentHelper.showHomePageFragment(HomePageFragment.newInstance())
    }

    internal fun activityReady(activity: FragmentHostActivity) {
        finishHostActivity(activity)
        this.fragmentHostActivity = activity
        if (::waitForActivity.isInitialized && !waitForActivity.isCompleted) {
            waitForActivity.resume(activity)
        }
    }
    private fun finishHostActivity(activity: FragmentHostActivity) {
        if (MainController::fragmentHostActivity.isInitialized && this.fragmentHostActivity != activity) {
            fragmentHostActivity.finish()
        }
    }
}