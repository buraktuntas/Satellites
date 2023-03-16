package com.satellites.core_ui.model

data class InputValueChange(
    val oldText: String? = "",
    val newText: String = "",
    val minLength: Int? = null,
    val maxLength: Int? = null,
    val isDigit: Boolean = false
)