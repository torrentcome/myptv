package com.example.myptv.domain.base.api

import retrofit2.Response

sealed class ApiResponse<T> {
    companion object {
        fun <T> create(error: Throwable): Error<T> {
            return Error(error.message ?: "Unknown error", 0)
        }

        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                val headers = response.headers()
                if (body == null || response.code() == 204) {
                    ApiEmptyResponse()
                } else {
                    Success(
                        body,
                        headers
                    )
                }
            } else {
                val msg = response.errorBody()?.string()
                val errorMsg = if (msg.isNullOrEmpty()) {
                    response.message()
                } else {
                    msg
                }
                Error(
                    errorMsg ?: "Unknown error",
                    response.code()
                )
            }
        }
    }
}

/**
 * separate class for HTTP 204 responses so that we can make ApiSuccessResponse's body non-null.
 */
class ApiEmptyResponse<T> : ApiResponse<T>()

data class Success<T>(
    val body: T?,
    val headers: okhttp3.Headers
) : ApiResponse<T>()

data class Error<T>(val errorMessage: String, val statusCode: Int) : ApiResponse<T>()