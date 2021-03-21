package com.death.nasa.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.death.nasa.ui.di.FragmentInjector
import javax.inject.Inject

abstract class BaseFragment<B: ViewDataBinding, VM:BaseViewModel<ViewEvent>, ViewEvent>: Fragment(){

    companion object {
        const val DEFAULT_ARGUMENTS_KEY = "DEFAULT_ARGUMENTS_KEY"
    }

    @Inject
    lateinit var viewModel: VM

    lateinit var binding: B

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun getFragmentTag(): String

    override fun onAttach(context: Context) {
        FragmentInjector.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        viewModel.onViewCreated()
    }

    abstract fun setupView(view: View)

    override fun onDetach() {
        super.onDetach()
    }


}