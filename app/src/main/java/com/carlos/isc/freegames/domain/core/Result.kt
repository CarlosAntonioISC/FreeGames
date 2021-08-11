package com.carlos.isc.freegames.domain.core
sealed class Result<T> {
    class Loading<T> : Result<T>()
    data class Success<T>(val data: T) : Result<T>()
    data class Failure(val exception: Exception) : Result<Nothing>()
}