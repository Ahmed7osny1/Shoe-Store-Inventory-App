package com.sriyank.shoestore.UI.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.sriyank.shoestore.R
import com.sriyank.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment+
        val binding = FragmentInstructionsBinding.inflate(inflater,
        container, false)

        //Go To Login Screen
        binding.nextInstruction.setOnClickListener {
            view: View ->
            view.findNavController().navigate(R.id.action_instructionsFragment_to_loginFragment)
        }

        return binding.root
    }

}