package com.kate.conbovang.extensions

import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.core.content.res.ResourcesCompat
import com.kate.conbovang.App


@ColorInt
fun Int.getColor(): Int {
    return ResourcesCompat.getColor(App.shared().resources, this, null)
}

fun Int.getString(): String{
    return App.shared().getString(this)
}

fun Int.getDrawable(): Drawable? {
    return ResourcesCompat.getDrawable(App.shared().resources, this, null)
}
