package com.death.nasa.utils

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun Int.toDate(): Date = Date(this.toLong() * 1000L)

fun Date.formatted():String {
    val simpleDateFormat = SimpleDateFormat("MMMM dd yyyy", Locale.getDefault())
    return simpleDateFormat.format(this)
}

fun Int.toFormattedDate():String = toDate().formatted()

class BindListItem<in R : RecyclerView.ViewHolder, out T : ViewDataBinding>(
    private val view: View
) : ReadOnlyProperty<R, T> {

    private var value: T? = null

    override operator fun getValue(thisRef: R, property: KProperty<*>): T {
        if (value == null) {
            value = DataBindingUtil.bind<T>(view)
        }
        return value!!
    }
}
