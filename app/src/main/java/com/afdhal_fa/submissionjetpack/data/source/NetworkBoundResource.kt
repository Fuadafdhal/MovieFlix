package com.afdhal_fa.submissionjetpack.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.afdhal_fa.submissionjetpack.data.source.remote.ApiResponse
import com.afdhal_fa.submissionjetpack.data.source.remote.StatusResponse
import com.afdhal_fa.submissionjetpack.utils.AppExecutors
import com.dicoding.academies.vo.Resource

abstract class NetworkBoundResource<ResultType, RequestType>(private val mExecutor: AppExecutors) {
    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)

        @Suppress("LeakingThis") val dbSource = loadFromDB()
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): LiveData<ResultType>

    protected abstract fun shouldFerch(data: ResultType?): Boolean

    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    protected abstract fun saveCallResult(data: RequestType)

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()

        result.addSource(dbSource) { newData ->
            result.value = Resource.loading(newData)
        }

        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when(response.status) {
                StatusResponse.SUCCESS -> {
                    mExecutor.diskIO().execute {
                        saveCallResult(response.body)
                        mExecutor.mainThread().execute {
                            result.addSource(loadFromDB()) { newData ->
                                result.value = Resource.success(newData)
                            }
                        }
                    }

                }
                StatusResponse.EMPTY -> {
                    mExecutor.mainThread().execute {
                        result.addSource(loadFromDB()) { newData ->
                            result.value = Resource.success(newData)
                        }
                    }
                }
                StatusResponse.ERROR -> {
                    onFetchFailed()
                    result.addSource(dbSource) { newData ->
                        result.value = Resource.error(response.message, newData)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<Resource<ResultType>> = result
}