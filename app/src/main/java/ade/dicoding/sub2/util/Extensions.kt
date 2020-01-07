package ade.dicoding.sub2.util

import ade.dicoding.sub2.R
import ade.dicoding.sub2.helper.SortUtils
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.SpinnerAdapter
import android.widget.TextView
import androidx.core.view.get
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_movie_fav.view.*

fun ImageView.loadImageURL(link: String?) {
    Glide.with(this.context)
        .load(link)
        .apply(
            RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
        )
        .into(this)
}

fun Boolean?.orFalse(): Boolean {
    return this ?: false
}

fun View.gone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

fun View.visible() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

fun View.invisible() {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
}

fun View.enable() {
    if (!isEnabled) isEnabled = true
}

fun View.clickable() {
    if (!isClickable) isClickable = true
}

fun View.disable() {
    if (isEnabled) isEnabled = false
}

fun View.unclickable() {
    if (isClickable) isClickable = false
}

fun spinnerSorterAdapter(context: Context): SpinnerAdapter {
    val sorter: List<String> = listOf(
        "Urutkan",
        SortUtils.NEWEST,
        SortUtils.OLDEST,
        SortUtils.ASCENDING,
        SortUtils.DESC
    )
    val spinnerArrayAdapter = object : ArrayAdapter<String>(
        context
        , R.layout.item_spinner_custom
        , sorter
    ) {
        override fun isEnabled(position: Int): Boolean {
            return position != 0
        }

        override fun getDropDownView(
            position: Int, convertView: View?,
            parent: ViewGroup
        ): View {
            val view = super.getDropDownView(position, convertView, parent)
            val tv = view as TextView
            if (position == 0) {
                tv.setTextColor(context.resources.getColor(R.color.colorTextSecondary))
            } else {
                tv.setTextColor(context.resources.getColor(android.R.color.black))
            }
            return view
        }

    }
    spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    return spinnerArrayAdapter
}

fun timeStamp() = System.currentTimeMillis()
fun Long.yesFav(): Boolean {
    return this > 0
}
