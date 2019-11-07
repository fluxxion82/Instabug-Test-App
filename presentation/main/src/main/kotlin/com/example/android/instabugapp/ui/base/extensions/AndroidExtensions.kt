package com.example.android.instabugapp.ui.base.extensions

import android.view.View
import android.view.Window
import androidx.fragment.app.Fragment

inline fun <reified T> Fragment.findCallback(): T? {
    var parent = parentFragment
    while (parent != null) {
        if (parent is T) {
            return parent
        }
        parent = parent.parentFragment
    }

    return activity as? T ?: activity?.application as? T
}

val Any.TAG: String
    get() = this::class.java.name

internal fun Window.clearLightStatusBar() {
    decorView.systemUiVisibility = decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
}

internal fun Window.enableLightStatusBar() {
    decorView.systemUiVisibility = decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
}
