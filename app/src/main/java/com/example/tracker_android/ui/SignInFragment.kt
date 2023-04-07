package com.example.tracker_android.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tracker_android.R
import com.example.tracker_android.databinding.FragmentSignInBinding
import com.example.tracker_android.databinding.FragmentWelcomeBinding

class SignInFragment : Fragment() {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var viewModel: SignInViewModel
    private lateinit var _binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        val view = _binding.root
        viewModel = ViewModelProvider(this)[SignInViewModel::class.java]
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
        // TODO: Use the ViewModel
    }

    internal fun setClickListeners() {
        _binding.signInBackButton.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.sign_in_container, WelcomeBackFragment.newInstance()).commitNow()
        }
    }

}