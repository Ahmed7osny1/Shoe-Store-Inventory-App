package com.sriyank.shoestore.UI.shoe

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.sriyank.shoestore.R
import com.sriyank.shoestore.databinding.FragmentShoeListBinding
import com.sriyank.shoestore.viewModel.ShoeViewModel

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = FragmentShoeListBinding.inflate(inflater,
            container, false)

        setHasOptionsMenu(true)

        val lp = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 5)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {

            val iterator = it.listIterator()
            for (item in iterator) {

                val _name = TextView(this.context)
                _name.text = item.name

                val _size = TextView(this.context)
                _size.text = item.size.toString()

                val _company = TextView(this.context)
                _company.text = item.company

                val _description = TextView(this.context)
                _description.text = item.description

                _name.setTextColor(Color.parseColor("#504359"))
                _size.setTextColor(Color.parseColor("#504359"))
                _company.setTextColor(Color.parseColor("#504359"))
                _description.setTextColor(Color.parseColor("#504359"))

                _name.textSize= 26F
                _size.textSize=22F
                _company.textSize=20F
                _description.textSize=15F


                val parentLayout = LinearLayout(this.context)

                val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
                )

                params.setMargins(5,0,5,25)
                parentLayout.orientation = LinearLayout.VERTICAL;

                parentLayout.setBackgroundColor(Color.parseColor("#9E9E9E"))
                parentLayout.setPadding(10,10,10,10)
                parentLayout.addView(_name)
                parentLayout.addView(_size)
                parentLayout.addView(_company)
                parentLayout.addView(_description)
                binding.shoeListView.addView(parentLayout,params)


            }
        })


        binding.createShoeButton.setOnClickListener{
            NavHostFragment.findNavController(this).navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)

        }


        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.over_menu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())
                ||super.onOptionsItemSelected(item)
    }

}