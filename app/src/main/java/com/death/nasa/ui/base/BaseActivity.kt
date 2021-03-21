package com.death.nasa.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.death.nasa.ui.di.Injector
import javax.inject.Inject

abstract class BaseActivity<B: ViewDataBinding, VM: BaseViewModel<ViewEvent>, ViewEvent>: AppCompatActivity() {

    @Inject
    lateinit var viewModel:VM

    lateinit var binding: B

    /**
     * Here @LayoutRes expects method to return int value, generally a layout resource
     */
    @LayoutRes
    protected abstract fun getLayoutId():Int

    protected abstract fun setupView(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.lifecycleOwner = this
        setupView(savedInstanceState)
        viewModel.onViewCreated()
    }

    fun showMessage(message: String) = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()

    fun showMessage(@StringRes resId:Int) = showMessage(getString(resId))
}