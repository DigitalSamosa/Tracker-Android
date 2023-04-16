package com.example.tracker_android.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tracker_android.controller.MainController
import com.example.tracker_android.databinding.FragmentWelcomeBinding
import com.example.tracker_android.util.FragmentHelper

class WelcomeFragment : Fragment() {

    companion object {
        fun newInstance() = WelcomeFragment()
    }
    val fragmentHelper = FragmentHelper()

    private lateinit var viewModel: WelcomeViewModel
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!
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

    internal fun setClickListeners() {
        binding.button.setOnClickListener {
            fragmentHelper.showAndAddToBackStack(HomePageFragment.newInstance())
        }
    }

}