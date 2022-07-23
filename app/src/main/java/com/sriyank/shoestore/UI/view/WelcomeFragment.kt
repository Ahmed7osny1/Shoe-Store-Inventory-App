package com.sriyank.shoestore.UI.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.sriyank.shoestore.R
import com.sriyank.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentWelcomeBinding.inflate(inflater,
            container, false)

        // Go To Next OnBoarding Screen( Instruction Fragment )
        binding.nextWelcome.setOnClickListener {
            view: View ->
            view.findNavController().navigate(R.id.action_welcomeFragment_to_instructionsFragment)
        }

        return binding.root
    }
}