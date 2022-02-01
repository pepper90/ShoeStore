package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.viewmodel.ShoeViewModel

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val sharedViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout with DataBindingUtil
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.fragment = this@ShoeListFragment

        sharedViewModel.listOfShoes.observe(viewLifecycleOwner) { list ->
            for (shoe in list) {
                val shoeBinding: ShoeItemBinding = DataBindingUtil.inflate(
                    inflater, R.layout.shoe_item, container, false
                )

                shoeBinding.shoe = shoe

                shoeBinding.apply {
                    if (shoe.images.isNullOrEmpty()) {
                        shoeItemImage.setImageResource(R.drawable.ic_blank_image)
                    } else
                        Glide.with(this@ShoeListFragment).load(shoe.images[0]).into(shoeItemImage)
                }

                binding.shoeListLinearLayout.addView(shoeBinding.root)
            }
        }

        return binding.root
    }

    fun openShoeDetails() {
        this.findNavController().navigate(
            ShoeListFragmentDirections
                .actionShoeListFragmentToShoeDetailFragment()
        )
    }
}