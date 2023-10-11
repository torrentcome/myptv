package com.example.myptv.domain.base.repo

import com.example.myptv.domain.base.api.ApiResponse
import com.example.myptv.domain.base.api.Error
import com.example.myptv.domain.base.api.Resource
import com.example.myptv.domain.base.api.Success
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

inline fun <Db, Api, Domain> bound(
    crossinline db: () -> Flow<Db>,
    crossinline shouldFetchApi: (Db?) -> Boolean = { true },
    crossinline api: () -> Flow<ApiResponse<Api>>,
    crossinline mapRes: (response: Db) -> Domain,
    crossinline saveApi: (Api) -> Unit = { },
    crossinline fetchFailed: (errorBody: String?, statusCode: Int) -> Unit = { _: String?, _: Int -> }
) = flow<Resource<Domain>> {

    emit(Resource.loading(null))

    val localData = db().first()

    if (shouldFetchApi(localData)) {
        emit(Resource.loading(mapRes(localData)))
        api().collect { apiResponse ->
            when (apiResponse) {
                is Success -> {
                    apiResponse.body?.let { saveApi(it) }
                    val domainFlow: Flow<Domain> = db().map { dbData -> mapRes(dbData) }
                    emitAll(domainFlow.map { Resource.success(it) })
                }

                is Error -> {
                    fetchFailed(apiResponse.errorMessage, apiResponse.statusCode)
                    val domainFlow: Flow<Domain> = db().map { dbData -> mapRes(dbData) }
                    emitAll(domainFlow.map {
                        Resource.error(
                            apiResponse.errorMessage,
                            it
                        )
                    })
                }
                else -> {
                    fetchFailed("unkown", -1)
                    val domainFlow: Flow<Domain> = db().map { dbData -> mapRes(dbData) }
                    emitAll(domainFlow.map {
                        Resource.error(
                            "unkown",
                            it
                        )
                    })
                }
            }
        }
    } else {
        val domainFlow: Flow<Domain> = db().map { dbData -> mapRes(dbData) }
        emitAll(domainFlow.map { Resource.success(it) })
    }
}