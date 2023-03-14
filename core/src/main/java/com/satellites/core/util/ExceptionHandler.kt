package com.satellites.core.util

import kotlinx.coroutines.CoroutineExceptionHandler
import timber.log.Timber

object ExceptionHandler {
    val handler = CoroutineExceptionHandler { _, throwable ->
        Timber.e(throwable, "CoroutineException")
    }
}