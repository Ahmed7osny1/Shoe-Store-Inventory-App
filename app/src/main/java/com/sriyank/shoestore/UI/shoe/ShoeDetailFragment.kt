package com.sriyank.shoestore.UI.shoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.sriyank.shoestore.R
import com.sriyank.shoestore.databinding.FragmentShoeDetailBinding
import com.sriyank.shoestore.viewModel.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = FragmentShoeDetailBinding.inflate(
            inflater,
            container,
            false
        )

        // Add new Shoe in List Screen
        binding.saveButton.setOnClickListener {

            viewModel.addShoe(
                  binding.nameBox.editText?.text.toString()
                , binding.companyBox.editText?.text.toString()
                , binding.sizeBox.editText?.text.toString().toInt()
                , binding.descriptionBox.editText?.text.toString()
            )

            NavHostFragment.findNavController(this)
                .navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)

        }

        // Cancel process to add new Shoe in List Screen
        binding.cancelButton.setOnClickListener {

            binding.nameBox.editText?.text?.clear()
            binding.sizeBox.editText?.text?.clear()
            binding.companyBox.editText?.text?.clear()
            binding.descriptionBox.editText?.text?.clear()

            NavHostFragment.findNavController(this)
                .navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)

        }

        return binding.root
    }
}