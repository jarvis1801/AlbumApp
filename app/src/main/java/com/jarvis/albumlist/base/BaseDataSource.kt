package com.jarvis.albumlist.base

import com.jarvis.albumlist.model.Resource
import retrofit2.Response

abstract class BaseDataSource {
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        return try {
            val response = call()
            val statusCode = response.code()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    return Resource.success(body, statusCode)
                }
            }
            error(response.message(), statusCode = statusCode)
        } catch (e: Exception) {
            error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String, statusCode: Int? = null): Resource<T> {
        return Resource.error("Network call has failed for a following reason: $message", statusCode = statusCode)
    }
}