package com.example.jangleproducerkt.ui.repository

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.jangleproducerkt.service.ApiResponse
import com.example.jangleproducerkt.service.Resource
import com.example.jangleproducerkt.service.Status
import com.example.jangleproducerkt.service.util.NetworkError
import com.example.jangleproducerkt.util.DebugLog
import java.util.*

abstract class NetworkFetch<NetworkType>
constructor(private val mNetworkError: NetworkError) : IBaseNetwork<NetworkType> {

    private val mResult = MediatorLiveData<Resource<NetworkType>>()

    init {
        DebugLog.write()
        fetchFromNetwork()
    }

    private fun fetchFromNetwork() {
        DebugLog.write()
        mResult.setValue(Resource.loading(null))
        val apiResponse = createCall() //
        mResult.addSource(apiResponse) { response ->
            mResult.removeSource(apiResponse)
            DebugLog.write(response.code.toString() + " " + response.errorMessage)
            val resource = mNetworkError.getNetworkErrorResource(response)
            if (resource.status === Status.ERROR || resource.status === Status.API_ERROR || resource.status === Status.UNAUTHORIZED) {
                //  setValue(resource)
            } else {
                val type = processResponse(response)
                setValue(Resource.success(type))
            }
        }
    }

    fun asLiveData(): LiveData<Resource<NetworkType>> {
        return mResult
    }


    @MainThread
    private fun setValue(newValue: Resource<NetworkType>) {
        if (!Objects.equals(mResult.getValue(), newValue)) {
            mResult.setValue(newValue)
        }
    }

    @WorkerThread
    private fun processResponse(response: ApiResponse<NetworkType>): NetworkType? {
        DebugLog.write()
        return response.body
    }

}
