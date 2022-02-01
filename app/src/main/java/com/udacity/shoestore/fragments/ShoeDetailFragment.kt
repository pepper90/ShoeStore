package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewModel


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val sharedViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout with DataBindingUtil
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            fragment = this@ShoeDetailFragment
            shoe = Shoe("", 0.0, "", "")
        }

        sharedViewModel.isSaved.observe(viewLifecycleOwner) { isSaved ->
            if (isSaved) {
                this.findNavController().navigate(
                    ShoeDetailFragmentDirections
                        .actionShoeDetailFragmentToShoeListFragment()
                )
                sharedViewModel.onSavedComplete()
            }
        }

        return binding.root
    }

    fun cancelShoeDetails() {
        this.findNavController().navigate(
            ShoeDetailFragmentDirections
                .actionShoeDetailFragmentToShoeListFragment()
        )
    }

}