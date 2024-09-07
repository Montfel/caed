package com.montfel.caed.domain.util

sealed interface ResultType<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResultType<T>
    data object Failure : ResultType<Nothing>
}

suspend fun <T : Any> resultWrapper(call: suspend () -> T): ResultType<T> {
    return runCatching {
        ResultType.Success(call())
    }.getOrElse { exception ->
        exception.printStackTrace()

        ResultType.Failure
    }
}