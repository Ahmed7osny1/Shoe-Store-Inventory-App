package com.sriyank.shoestore.viewModel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sriyank.shoestore.Model.Shoe

class ShoeViewModel: ViewModel() {

    val shoeList = MutableLiveData<MutableList<Shoe>>()

    init {
        shoeList.value = ArrayList()
    }

    fun addShoe( name: String,  company: String, size: Int,  description: String) {
        var shoe = Shoe(name, company, size, description)
        shoeList.value?.add(shoe)
        shoeList.value = shoeList.value

    }
}