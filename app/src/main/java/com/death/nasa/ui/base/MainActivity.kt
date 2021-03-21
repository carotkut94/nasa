package com.death.nasa.ui.base

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.death.nasa.R
import com.death.nasa.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel, MainContract.ViewEvent>() {
    override fun getLayoutId(): Int  = R.layout.activity_main
    override fun setupView(savedInstanceState: Bundle?) {
    }
}