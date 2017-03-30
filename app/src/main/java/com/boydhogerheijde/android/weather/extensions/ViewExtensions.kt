package com.boydhogerheijde.android.weather.extensions

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * @author Boyd Hogerheijde.
 */
fun ViewGroup.inflateLayout(@LayoutRes layoutRes: Int): View
        = LayoutInflater.from(context).inflate(layoutRes, this, false)

fun ImageView.load(url: String) {
    Picasso.with(context).load(url).into(this)
}