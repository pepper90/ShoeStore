package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout with DataBindingUtil
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)

        // Set click listener for Continue button
        binding.btnContinue.setOnClickListener {
            this.findNavController().navigate(
                InstructionFragmentDirections
                    .actionInstructionFragmentToShoeListFragment()
            )
        }

        return binding.root
    }

}