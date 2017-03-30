package com.boydhogerheijde.android.weather.extensions

import android.os.Build
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * @author Boyd Hogerheijde.
 */
inline fun <reified T : Fragment> AppCompatActivity.findFragment(@IdRes id: Int): T?
        = supportFragmentManager.findFragmentById(id) as? T

fun AppCompatActivity.addFragment(@IdRes containerId: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
            .add(containerId, fragment)
            .commit()
}

inline fun supportsLollipop(code: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        code()
    }
}
