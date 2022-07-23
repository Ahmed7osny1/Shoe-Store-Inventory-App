package com.sriyank.shoestore.UI.view

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.sriyank.shoestore.R
import com.sriyank.shoestore.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Handler().postDelayed({

            if(checkLoggedIn()){
                findNavController().navigate(R.id.action_splashFragment_to_shoeListFragment)
            }
            else if(onBoardingFinished()) {
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_welcomeFragment)
            }

                              },3500)


        // Inflate the layout for this fragment
        val binding = FragmentSplashBinding.inflate(inflater, container, false)

        return binding.root
    }

    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }

    private fun checkLoggedIn() : Boolean{
        // check if user is logged in
        val prefs = requireActivity().getSharedPreferences(
            "logger",
            AppCompatActivity.MODE_PRIVATE
        )
        val token = prefs.getString("logged", null) ?: return false
        return true
    }

}