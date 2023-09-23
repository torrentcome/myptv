package com.example.myptv.domain.base

import com.example.myptv.presentation.base.UseCaseResponse
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class UseCase<Type, in Params>() where Type : Any {
    abstract suspend fun run(params: Params? = null): Type
    fun invoke(scope: CoroutineScope, params: Params?, onResult: UseCaseResponse<Type>?) {
        scope.launch {
            try {
                val result = run(params)
                onResult?.onSuccess(result)
            } catch (e: CancellationException) {
                e.printStackTrace()
                onResult?.onError(e)
            } catch (e: Exception) {
                e.printStackTrace()
                onResult?.onError(e)
            }
        }
    }
}