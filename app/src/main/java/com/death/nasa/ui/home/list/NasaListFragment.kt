package com.death.nasa.ui.home.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.death.nasa.R
import com.death.nasa.data.model.NasaImage
import com.death.nasa.databinding.NasaListFragmentBinding
import com.death.nasa.ui.base.BaseFragment
import com.death.nasa.ui.home.list.item.NasaImageAdapter
import com.death.nasa.ui.home.list.item.NasaListBindingModel
import com.death.nasa.utils.common.ItemDecoration
import com.fueled.reclaim.ItemsViewAdapter

class NasaListFragment : BaseFragment<NasaListFragmentBinding, NasaListViewModel, NasaListContract.ViewEvent>(){

    override fun getLayoutId() = R.layout.nasa_list_fragment
    override fun getFragmentTag(): String = "NasaListFragment"
    private val nasaImageAdapter = ItemsViewAdapter()
    private val bindingModel = NasaListBindingModel()

    override fun setupView(view: View) {
        binding.model = bindingModel
        binding.images.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = nasaImageAdapter
            addItemDecoration(ItemDecoration(20))
        }

        viewModel.viewStates().observe(this, viewStateObserver)
    }


    private val viewStateObserver = Observer<NasaListContract.ViewState> {
        renderViewState(it)
    }

    private fun renderViewState(it: NasaListContract.ViewState?) {
        it?.run {
            bindingModel.loading = loadStatus == NasaListContract.LoadStatus.Loading
            bindingModel.showError = loadStatus == NasaListContract.LoadStatus.Error

            if(!nasaImages.isNullOrEmpty()){
                val items = nasaImages.map {
                    NasaImageAdapter(it, ::onItemClick)
                }

                nasaImageAdapter.replaceItems(items, true)
            }
        }
    }

    private fun onItemClick(nasaImage:NasaImage){
        findNavController().navigate(NasaListFragmentDirections.moveToDetail(nasaImage))
    }

}