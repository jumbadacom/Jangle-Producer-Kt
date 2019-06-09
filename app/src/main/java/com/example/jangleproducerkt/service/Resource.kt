package com.example.jangleproducerkt.service

import com.example.jangleproducerkt.service.Status.*

/**
 * A generic class that holds a value with its loading status.
 */
data class Resource<T>(
    val status: Status,
    val errorDetail: String?,
    val data: T?,
    val message: String?
) {


    override fun toString(): String {
        val sb = StringBuilder("Resource{")
        sb.append("status=").append(status)
        sb.append(", errorDetail='").append(errorDetail).append('\'')
        sb.append(", message='").append(message).append('\'')
        sb.append(", data=").append(data)
        sb.append('}')
        return sb.toString()
    }

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(SUCCESS, null, data, null)
        }

        fun <T> error(errorDetail: String, data: T?, msg: String?): Resource<T> {
            return Resource(ERROR, errorDetail, data, msg)
        }

        fun <T> apiError(errorDetail: String, data: T?, msg: String?): Resource<T> {
            return Resource(API_ERROR, errorDetail, data, msg)
        }

        fun <T> unauthorized(errorDetail: String, data: T?, msg: String?): Resource<T> {
            return Resource(UNAUTHORIZED, errorDetail, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(LOADING, null, data, null)
        }

        fun <T> empty(data: T?): Resource<T> {
            return Resource(EMPTY_DATA, null, data, null)
        }
    }
}
