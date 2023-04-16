package com.example.tracker_android.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.tracker_android.controller.MainController
import java.io.Serializable

class MainViewModel : ViewModel(), Serializable {

    fun initializeController(context: Context) {
        MainController.initialize(context)
    }
}
