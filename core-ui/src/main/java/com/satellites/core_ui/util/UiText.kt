package com.satellites.core_ui.util

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UiText {
    data class DynamicString(val text: String) : UiText()
    class StringResource(
        @StringRes val resId: Int,
        vararg val args: String
    ) : UiText()

    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> text
            is StringResource -> stringResource(id = resId, formatArgs = args)
        }
    }
}