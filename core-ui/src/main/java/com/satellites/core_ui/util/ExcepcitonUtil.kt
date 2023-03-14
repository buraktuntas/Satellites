package com.satellites.core_ui.util

import com.satellites.core.data.remote.interceptor.DefaultHeaderInterceptor
import com.satellites.core_ui.R

fun Throwable?.getExceptionMessage(): UiText {
    return when (this) {
        is DefaultHeaderInterceptor.SatellitesRetrofitException -> {
            val message = this.message
            if (message != null) {
                UiText.DynamicString(message)
            } else {
                UiText.StringResource(R.string.common_error_txt_unknown)
            }
        }
        else -> {
            UiText.StringResource(R.string.common_error_txt_unknown)
        }
    }
}