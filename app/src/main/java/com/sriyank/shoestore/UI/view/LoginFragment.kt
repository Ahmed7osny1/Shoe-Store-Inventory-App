package com.sriyank.shoestore.UI.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.navigation.findNavController
import com.sriyank.shoestore.R
import com.sriyank.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = FragmentLoginBinding.inflate(inflater,
        container, false)

        //Go To Shoe List Fragment
        binding.login.setOnClickListener {
                view: View ->
                view.findNavController().navigate(R.id.action_loginFragment_to_shoeListFragment)
        }

        //Go To Shoe List Fragment
        binding.signUp.setOnClickListener {
                view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_shoeListFragment)
        }

        return binding.root
    }
}