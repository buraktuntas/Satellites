package com.satellites.core_ui.util

import com.satellites.core_ui.model.NavigationType

sealed class UiEvent {
    data class Navigate<T>(
        val navigationType: NavigationType,
        val data: T? = null
    ) : UiEvent()

    data class ShowError(val throwable: Throwable?) : UiEvent()
    data class ShowLoading(val showLoading: Boolean) : UiEvent()
    data class Scroll(val position: Int) : UiEvent()
    object CloseBottomSheet : UiEvent()
}