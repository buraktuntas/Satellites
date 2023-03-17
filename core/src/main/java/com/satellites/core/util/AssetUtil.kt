package com.satellites.core.util

import android.content.Context

fun Context.readFromAsset(file : String)  :String {
    var data = ""
    this.assets.open(file).apply {
        data = this.readBytes().toString(Charsets.UTF_8)
    }.close()
    return data
}