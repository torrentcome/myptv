package com.example.myptv.data.base

import java.lang.Exception

interface UseCaseResponse<Type> {
    fun onSuccess(result: Type)
    fun onError(exception: Exception?)
}