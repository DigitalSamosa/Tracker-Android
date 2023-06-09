package com.example.tracker_android.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tracker_android.databinding.FragmentSignInBinding
import com.example.tracker_android.util.FragmentHelper

class SignInFragment : Fragment() {

    companion object {
        fun newInstance() = SignInFragment()
    }
    val fragmentHelper = FragmentHelper()

    private lateinit var viewModel: SignInViewModel
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[SignInViewModel::class.java]
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
        binding.signInBackButton.setOnClickListener {
            fragmentHelper.fragmentOnBackPressed()
        }
    }

}