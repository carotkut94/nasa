package com.death.nasa.ui.detail

import android.os.Bundle
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.transition.ChangeBounds
import androidx.transition.TransitionInflater
import coil.load
import com.death.nasa.R
import com.death.nasa.databinding.FragmentDetailBinding
import com.death.nasa.utils.common.BindFragment

class DetailFragment : Fragment() {
    private val fragmentDetailBinding:FragmentDetailBinding by BindFragment(R.layout.fragment_detail)
    private val args by navArgs<DetailFragmentArgs>()

    private val callback: OnBackPressedCallback =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigateUp()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().onBackPressedDispatcher.addCallback(requireActivity(), callback)
        setHasOptionsMenu(true)
        return fragmentDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.run {
           fragmentDetailBinding.run {
               poster.load(nasaImage.hdurl){
                   placeholder(R.drawable.ic_loader)
               }
               headline.text = nasaImage.title
           }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.detail_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.info){
            findNavController().navigate(
                DetailFragmentDirections.actionDetailFragmentToInfoDialogBottomSheet(
                    args.nasaImage.explanation
                )
            )
        }
        return true
    }
}