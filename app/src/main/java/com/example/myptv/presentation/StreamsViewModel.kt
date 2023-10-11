package com.example.myptv.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myptv.domain.GetStreamsFlowUseCase
import com.example.myptv.domain.base.api.Resource
import com.example.myptv.domain.model.Stream
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.map

class StreamsViewModel constructor(getStreamsFlowUseCase: GetStreamsFlowUseCase) : ViewModel() {

    val data: LiveData<Resource<List<Stream>>> = getStreamsFlowUseCase.run().map {
        when (it.status) {
            Resource.Status.LOADING -> {
                Resource.loading(null)
            }

            Resource.Status.SUCCESS -> {
                Resource.success(it.data)
            }

            Resource.Status.ERROR -> {
                Resource.error(it.message!!, null)
            }
        }
    }.asLiveData(viewModelScope.coroutineContext)

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}