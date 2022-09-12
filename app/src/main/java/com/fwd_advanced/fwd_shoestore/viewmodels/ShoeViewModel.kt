package com.fwd_advanced.fwd_shoestore.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fwd_advanced.fwd_shoestore.model.Shoe

class ShoeViewModel : ViewModel() {

    var _shoeList= MutableLiveData<MutableList<Shoe>>()

    val shoeList:LiveData<MutableList<Shoe>>
    get() = _shoeList

    init {
        _shoeList.value= mutableListOf()
    }


     fun addShoe(shoe:Shoe){
        _shoeList.value?.add(shoe)
         Log.e("TestInsertedItem",shoe.toString())
    }

}