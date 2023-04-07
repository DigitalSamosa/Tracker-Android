package com.example.tracker_android.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.tracker_android.R
import com.example.tracker_android.databinding.FragmentWelcomeBinding
import com.google.android.material.button.MaterialButton

class WelcomeFragment : Fragment() {

    companion object {
        fun newInstance() = WelcomeFragment()
    }

    private lateinit var viewModel: WelcomeViewModel
    private lateinit var _binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val view = _binding!!.root
        viewModel = ViewModelProvider(this)[WelcomeViewModel::class.java]
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
    }

    internal fun setClickListeners() {
        _binding.button.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.welcome_container, WelcomeBackFragment.newInstance()).commitNow()
        }
    }

}