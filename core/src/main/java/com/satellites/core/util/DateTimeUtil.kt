package com.satellites.core.util


import java.text.SimpleDateFormat
import java.util.*

private const val DATE_TIME_FORMAT_1 = "yyyy-MM-dd"
private const val DATE_TIME_FORMAT_2 = "dd.MM.yyyy"

fun String.changeDateFormat(): String {
    val inputDateFormat = SimpleDateFormat(DATE_TIME_FORMAT_1, Locale.getDefault())
    val outputDateFormat = SimpleDateFormat(DATE_TIME_FORMAT_2, Locale.getDefault())
    val date = inputDateFormat.parse(this)
    return outputDateFormat.format(date)
}