package com.satellites.core.util

fun Int.formatWithDots(): String {
    val reversedString = this.toString().reversed()
    val builder = StringBuilder()

    for (i in reversedString.indices) {
        if (i % 3 == 0 && i != 0) {
            builder.append('.')
        }
        builder.append(reversedString[i])
    }
    return builder.reverse().toString()
}