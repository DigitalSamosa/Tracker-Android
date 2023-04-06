package com.example.tracker_android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tracker_android.R

class WelcomeBackFragment : Fragment() {

    companion object {
        fun newInstance() = WelcomeBackFragment()
    }

    private lateinit var viewModel: WelcomeBackViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[WelcomeBackViewModel::class.java]
        return inflater.inflate(R.layout.fragment_welcome_back, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}