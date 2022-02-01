package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout with DataBindingUtil
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        // Set click listener for Sign in button
        binding.btnSignIn.setOnClickListener {
            val input = binding.tiEmail.editText?.text.toString()
            if (input.isEmpty()) {
                binding.tiEmail.error = getString(R.string.field_is_required)
            } else {
                this.findNavController().navigate(
                    LoginFragmentDirections
                        .actionLoginFragmentToWelcomeFragment(
                        input //safe arg
                    )
                )
            }
        }

        // Set click listener for Sin up button
        binding.btnSignUp.setOnClickListener {
            val input = binding.tiEmail.editText?.text.toString()
            if (input.isEmpty()) {
                binding.tiEmail.error = getString(R.string.field_is_required)
            } else {
                this.findNavController().navigate(
                    LoginFragmentDirections
                        .actionLoginFragmentToWelcomeFragment(
                        input //safe arg
                    )
                )
            }
        }

        return binding.root
    }
}