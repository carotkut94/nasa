
package com.death.nasa.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.death.nasa.R
import com.death.nasa.databinding.InfoBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class InfoDialogBottomSheet : BottomSheetDialogFragment() {

    private val args by navArgs<InfoDialogBottomSheetArgs>()
    private lateinit var binding: InfoBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.info_bottom_sheet, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.infoText.text = args.explaination
    }

}