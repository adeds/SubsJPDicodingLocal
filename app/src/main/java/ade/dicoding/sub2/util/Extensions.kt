package ade.dicoding.sub2.util

import ade.dicoding.sub2.R
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

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

