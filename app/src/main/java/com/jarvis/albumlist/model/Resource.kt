package com.jarvis.albumlist.model

data class Resource<T>(val status: Status, val data: T?, val message: String?, val statusCode: Int? = null) {
    companion object {
        fun <T> success(data: T, statusCode: Int? = null): Resource<T> =
            Resource(status = Status.SUCCESS, data = data, message = null, statusCode = statusCode)

        fun <T> error(message: String, statusCode: Int? = null): Resource<T> =
            Resource(status = Status.ERROR, data = null, message = message, statusCode = statusCode)
    }
}


enum class Status {
    SUCCESS,
    ERROR
}