package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Constants
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _listOfShoes =  MutableLiveData<MutableList<Shoe>>()
    val listOfShoes : LiveData<MutableList<Shoe>>
        get() = _listOfShoes

    private val _isSaved = MutableLiveData<Boolean>()
    val isSaved: LiveData<Boolean>
        get() = _isSaved

    init {
        /*Pre-populated values for testing purposes*/
        _listOfShoes.value = Constants.shoes
        _isSaved.value = false
    }

    fun addNewShoe(shoe: Shoe) {
        _listOfShoes.value?.add(shoe)
        _isSaved.value = true
    }

    fun onSavedComplete(){
        _isSaved.value = false
    }
}