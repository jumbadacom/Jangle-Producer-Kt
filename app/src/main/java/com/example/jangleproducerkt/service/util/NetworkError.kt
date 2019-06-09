package com.example.jangleproducerkt.service.util

import com.example.jangleproducerkt.service.ApiResponse
import com.example.jangleproducerkt.service.Resource
import com.example.jangleproducerkt.service.result.error.ErrorResponseModel
import com.example.jangleproducerkt.util.DebugLog
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.JsonParser

import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkError @Inject constructor(private val mGson: Gson) {

    fun getNetworkErrorResource(response: ApiResponse<*>): Resource<*> {
        return if (!response.isSuccessful) {
            //errors generated from own restful service of the app
            if (response.isRestApiError || response.isUnauthorized) {
                DebugLog.write();
                try {
                    val errorBody = response.errorBody!!.string()
                    DebugLog.write(errorBody);
                    val errResModel = getErrorModel(errorBody)
                    if (response.isRestApiError) {
                        Resource.apiError(errResModel.detail, errResModel, errResModel.title)
                    } else {
                        Resource.unauthorized(errResModel.detail, errResModel, errResModel.title)
                    }
                } catch (e: IOException) {
                    e.message?.let { DebugLog.write(it) };
                    Resource.error(response.code.toString() + " " + e.message, null, e.message)
                } catch (e: JsonParseException) {
                    Resource.error(response.code.toString() + " " + e.message, null, e.message)
                }

            } else {
                // DebugLog.write(response.code);
                Resource.error(response.code.toString() + " " + response.errorMessage, null, response.errorMessage)

            }
        } else Resource.success(null)
    }


    @Throws(JsonParseException::class)
    private fun getErrorModel(error: String): ErrorResponseModel {

        val errorResponse: ErrorResponseModel
        val parser = JsonParser()
        val mJson: JsonElement
        try {
            mJson = parser.parse(error)
            errorResponse = mGson.fromJson(mJson, ErrorResponseModel::class.java)
        } catch (e: JsonParseException) {
            throw e
        }

        return errorResponse
    }
}
