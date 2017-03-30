package com.boydhogerheijde.android.weather.extensions

import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment

/**
 * @author Boyd Hogerheijde.
 */
fun Fragment.showSnackbar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
    if (view != null) {
        Snackbar.make(view!!, message, duration).show()
    }
}