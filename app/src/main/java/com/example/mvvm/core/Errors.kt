package com.example.mvvm.core

sealed class Errors : Throwable() {
    data class NetworkError(val code: Int = -1, val desc: String = "") : Errors()
    object EmptyInputError : Errors()
    object EmptyResultsError : Errors()
    object SingleError : Errors()
    object NoInternetError : Errors()
}