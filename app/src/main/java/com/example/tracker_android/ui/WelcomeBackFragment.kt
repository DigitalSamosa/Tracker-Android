package com.example.tracker_android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.tracker_android.R
import com.example.tracker_android.databinding.FragmentWelcomeBackBinding

class WelcomeBackFragment : Fragment() {

    companion object {
        fun newInstance() = WelcomeBackFragment()
    }

    private lateinit var viewModel: WelcomeBackViewModel
    private lateinit var binding: FragmentWelcomeBackBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBackBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[WelcomeBackViewModel::class.java]
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//    }

    internal fun setClickListeners() {
        binding.toSignInButton.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.welcome_back_container, SignInFragment.newInstance()).commitNow()
        }

        binding.backButton.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.welcome_back_container, WelcomeFragment.newInstance()).commitNow()
        }
    }

}