package com.example.tracker_android.util

import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.tracker_android.R
import com.example.tracker_android.controller.MainController
import com.example.tracker_android.ui.FragmentHostActivity
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.lifecycleScope

class FragmentHelper {

    internal fun showAndAddToBackStack(fragment: Fragment, executor: Executor = mExecutor()) {
        executor.launchMain {
            MainController.startActivity()
            MainController.fragmentHostActivity.supportFragmentManager.beginTransaction()
                .addToBackStack(fragment.toString())
                .add(R.id.fragment_container_host, fragment)
                .commit()
        }
    }

    internal fun fragmentOnBackPressed() {
        if (MainController.fragmentHostActivity.supportFragmentManager.backStackEntryCount > 1) {
            MainController.fragmentHostActivity.supportFragmentManager.popBackStackImmediate()
        } else {
            MainController.fragmentHostActivity.finish()
        }
    }

    internal fun startFragmentHostActivity() {
        val intent = Intent(MainController.context, FragmentHostActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NO_ANIMATION
        MainController.context.startActivity(intent)
    }

    internal fun showWelcomeFragment(fragment: Fragment, executor: Executor = mExecutor()) {
        ProcessLifecycleOwner.get().lifecycleScope.launchWhenResumed {
            executor.launchMain {
                MainController.startWelcomeFragment()
            }
        }
    }

    internal fun showHomePageFragment(fragment: Fragment, executor: Executor = mExecutor()) {
        ProcessLifecycleOwner.get().lifecycleScope.launchWhenResumed {
            executor.launchMain {
                MainController.startHomePageFragment()
            }
        }
    }
}