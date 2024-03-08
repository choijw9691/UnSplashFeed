package com.gemvaxlink.unsplashfeed.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.math.ln
import kotlin.math.pow


fun <T> Flow<T>.toMutableStateFlow(scope: CoroutineScope, initialState: T): MutableStateFlow<T> {
    val stateFlow = MutableStateFlow(initialState)
    scope.launch {
        this@toMutableStateFlow.collect { value ->
            stateFlow.value = value
        }
    }
    return stateFlow
}

fun Int.toPrettyString(): String {
    if (this < 1000) return "$this"
    val exp = (ln(this.toDouble()) / ln(1000.0)).toInt()
    return String.format("%.1f%c", this / 1000.0.pow(exp.toDouble()), "KMGTPE"[exp - 1])
}