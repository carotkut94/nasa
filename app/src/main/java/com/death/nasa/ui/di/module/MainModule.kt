package com.death.nasa.ui.di.module

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.death.nasa.data.repository.NasaImageRepository
import com.death.nasa.ui.base.BaseActivity
import com.death.nasa.ui.base.BaseFragment
import com.death.nasa.ui.base.MainActivity
import com.death.nasa.ui.base.MainViewModel
import com.death.nasa.ui.home.list.NasaListViewModel
import com.death.nasa.utils.common.ViewModelProviderFactory
import com.death.nasa.utils.rx.SchedulerProvider
import com.fueled.reclaim.ItemsViewAdapter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class MainModule(private val activity: MainActivity): BaseActivityModule(activity){

    @Provides
    fun provideHomeViewModel(
        schedulerProvider: SchedulerProvider,
    ): MainViewModel = ViewModelProvider(activity, ViewModelProviderFactory(MainViewModel::class){
        MainViewModel(schedulerProvider)
    }).get(MainViewModel::class.java)

}

@Module
class FragmentModule(private val fragment:BaseFragment<*,*,*>):BaseFragmentModule(fragment){

    @Provides
    fun provideListViewModel(schedulerProvider: SchedulerProvider, nasaImageRepository: NasaImageRepository): NasaListViewModel = ViewModelProvider(fragment, ViewModelProviderFactory(NasaListViewModel::class){
        NasaListViewModel(schedulerProvider, nasaImageRepository)
    }).get(NasaListViewModel::class.java)

}