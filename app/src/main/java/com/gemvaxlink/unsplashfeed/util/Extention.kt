package com.gemvaxlink.unsplashfeed.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


fun <T> Flow<T>.toMutableStateFlow(scope: CoroutineScope, initialState: T): MutableStateFlow<T> {
    val stateFlow = MutableStateFlow(initialState)
    scope.launch {
        this@toMutableStateFlow.collect { value ->
            stateFlow.value = value
        }
    }
    return stateFlow
}
