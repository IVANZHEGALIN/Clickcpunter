package com.example.clickcpunter


import android.graphics.Color
import androidx.core.graphics.green
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel () : ViewModel() {

    private val _flowState = MutableStateFlow(Color.WHITE)
    val color = _flowState.asStateFlow()


    fun setColor (color : Int ) {
        _flowState.value = color
    }

}






