package com.example.myapplication

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("imageUrl")
fun imageUrl(view: ImageView, url: String?) {

    val options = RequestOptions()
        .placeholder(placeholderProgressBar(view.context))
        .error(R.color.white)

    Glide.with(view.context)
        .setDefaultRequestOptions(options)
        .load(url).transform(CircleCrop())
        .into(view)
}

fun placeholderProgressBar(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}


