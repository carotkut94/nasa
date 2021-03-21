package com.death.nasa.ui.home.list.item

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.death.nasa.R
import com.death.nasa.data.model.NasaImage
import com.death.nasa.databinding.CardNasaPhotoBinding
import com.death.nasa.utils.BindListItem
import com.fueled.reclaim.AdapterItem
import com.fueled.reclaim.BaseViewHolder


class NasaImageAdapter(
    private val nasaImage: NasaImage,
    private val listener : (NasaImage) -> Unit
) : AdapterItem<NasaImageViewHolder>() {

    override val layoutId: Int = R.layout.card_nasa_photo

    override fun onCreateViewHolder(view: View): NasaImageViewHolder = NasaImageViewHolder(view)

    override fun updateItemViews(viewHolder: NasaImageViewHolder) {
        viewHolder.itemBinding.run {
            headline.text = nasaImage.title
            poster.load(nasaImage.hdurl){
                placeholder(R.drawable.ic_launcher_background)
            }
            headline.setBackgroundColor(Color.BLACK)
            headline.setTextColor(Color.WHITE)

            root.setOnClickListener {
                listener(nasaImage)
            }
        }
    }

    override fun isContentsTheSame(newItem: AdapterItem<*>): Boolean {
        return isTheSame(newItem) && (newItem as NasaImageAdapter).nasaImage == nasaImage
    }

    override fun isTheSame(newItem: AdapterItem<*>): Boolean {
        return newItem is NasaImageAdapter
    }
}


class NasaImageViewHolder(itemView: View) : BaseViewHolder(itemView) {
    val itemBinding : CardNasaPhotoBinding by BindListItem(itemView)
}

