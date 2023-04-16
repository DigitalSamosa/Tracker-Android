package com.example.tracker_android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tracker_android.R
import com.example.tracker_android.databinding.FragmentHomePageBinding
import com.example.tracker_android.util.FragmentHelper

class HomePageFragment : Fragment() {

    companion object {
        fun newInstance() = HomePageFragment()
    }
    val fragmentHelper = FragmentHelper()

    private lateinit var viewModel: HomePageViewModel
    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[HomePageViewModel::class.java]
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentHelper.showAndAddToBackStack(WelcomeFragment.newInstance(), animEnter = R.anim.slide_up, animPop = R.anim.slide_down)
        setClickListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    internal fun setClickListeners() {
        binding.toSignInButton.setOnClickListener {
            fragmentHelper.showAndAddToBackStack(SignInFragment.newInstance())
        }

        binding.backButton.setOnClickListener {
            fragmentHelper.showAndAddToBackStack(WelcomeFragment.newInstance(), animEnter = R.anim.slide_up, animPop = R.anim.slide_down)
        }
    }

}