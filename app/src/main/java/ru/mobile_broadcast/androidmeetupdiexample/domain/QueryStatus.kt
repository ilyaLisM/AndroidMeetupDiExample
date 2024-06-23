package ru.mobile_broadcast.androidmeetupdiexample.domain

sealed class QueryStatus<T>(val data: T? = null, val message: String? = null) {

    class Loading<T>(data: T? = null) : QueryStatus<T>(data)

    class Success<T>(data: T?) : QueryStatus<T>(data)

    class Error<T>(message: String, data: T? = null) : QueryStatus<T>(data, message)
}