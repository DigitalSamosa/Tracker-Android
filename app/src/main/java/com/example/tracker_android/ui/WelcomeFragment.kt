package com.example.tracker_android.ui

import android.app.ProgressDialog.show
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.tracker_android.controller.MainController
import com.example.tracker_android.databinding.FragmentWelcomeBinding
import com.example.tracker_android.util.FragmentHelper
import com.google.android.material.snackbar.Snackbar

class WelcomeFragment : Fragment() {

    companion object {
        fun newInstance() = WelcomeFragment()
    }
    val fragmentHelper = FragmentHelper()

    private lateinit var viewModel: WelcomeViewModel
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!
    private val sharedPrefs = MainController.sharedPrefs
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[WelcomeViewModel::class.java]
        Log.d("dexter", "welcome fragment")
        MainController.welcomeFragmentReady(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    internal var onBackPressedCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            fragmentHelper.fragmentOnBackPressed()
        }
    }

    internal fun setClickListeners() {
        binding.welcomeToolbar.setNavigationOnClickListener {
            this.onBackPressedCallback.handleOnBackPressed()
        }

        binding.remindMeLaterButton.setOnClickListener {
            sharedPrefs.edit().putBoolean("remind_me_again", true).apply()
            fragmentHelper.fragmentOnBackPressed()
            showRemindMeAgainSnackbar()
        }
    }

    private fun showRemindMeAgainSnackbar() {
        view?.let { Toast.makeText(context, "We'll remind you the next time you launch the app", Toast.LENGTH_SHORT)
            .show()}
    }
}