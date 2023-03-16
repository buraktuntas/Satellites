package com.satellites.core_ui.util

import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import com.satellites.core_ui.model.NavigationType

sealed class UiEvent {
    data class Navigate<T>(
        val navigationType: NavigationType,
        val data: T? = null
    ) : UiEvent()

    data class ShowError(val throwable: Throwable?) : UiEvent()
    data class ShowLoading(val showLoading: Boolean) : UiEvent()
    object OpenKeyboard : UiEvent()
    object CloseKeyboard : UiEvent()
    data class RequestFocus(val focusRequester: FocusRequester) : UiEvent()
    data class MoveFocus(val focusDirection: FocusDirection) : UiEvent()
}