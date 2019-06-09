package com.example.jangleproducerkt.service


import com.example.jangleproducerkt.util.DebugLog
import okhttp3.ResponseBody
import retrofit2.Response

import java.text.MessageFormat

/**
 * Common class used by API responses.
 */
class ApiResponse<T> {


    val code: Int
    val body: T?
    val errorBody: ResponseBody?
    val errorMessage: String?

    val isSuccessful: Boolean
        get() = code >= 200 && code < 300

    val isRestApiError: Boolean
        get() = code == REST_API_MANAGED_ERROR

    val isUnauthorized: Boolean
        get() = code == REST_API_UNAUTHORIZED

    val isEmpty: Boolean
        get() = body == null

    constructor(model: T) {
        DebugLog.write()
        code = 200
        body = model
        errorBody = null
        errorMessage = null
    }


    constructor(error: Throwable) {
        DebugLog.write()
        code = 500
        body = null
        errorBody = null
        errorMessage = error.message
    }

    constructor(response: Response<T>) {

        code = response.code()
        DebugLog.write(MessageFormat.format("code -> {0}", code))

        if (isSuccessful) {
            body = response.body()
            errorBody = null
            errorMessage = null
        } else if (isUnauthorized) {
            body = null
            errorBody = response.errorBody()
            errorMessage = null
        } else if (isRestApiError) {
            body = null
            errorBody = response.errorBody()
            errorMessage = null
        } else {
            DebugLog.write()
            errorBody = null
            body = null
            errorMessage = response.message()
        }


    }

    companion object {

        val REST_API_UNAUTHORIZED = 401
        val REST_API_MANAGED_ERROR = 422
    }

}
