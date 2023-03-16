package com.satellites.core.util

import android.content.Context

fun Context.readFromAsset(file : String)  :String {
    var json_string = "";
    this.assets.open(file).apply {
        json_string = this.readBytes().toString(Charsets.UTF_8)
    }.close()
    return json_string
}