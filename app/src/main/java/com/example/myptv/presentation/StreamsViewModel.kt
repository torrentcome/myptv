package com.example.myptv.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myptv.data.Repo
import com.example.myptv.domain.GetStreamsFlowUseCase
import com.example.myptv.domain.base.api.ResultData
import com.example.myptv.domain.model.Stream
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class StreamsViewModel constructor(private val repo: Repo) : ViewModel() {

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData

    internal val _successLiveData = MutableLiveData<MutableList<Stream>?>()
    val successLiveData: LiveData<MutableList<Stream>?> get() = _successLiveData

    private val _messageLiveData = MutableLiveData<String>()
    val messageLiveData: LiveData<String> get() = _messageLiveData

    private val _errorLiveData = MutableLiveData<Throwable>()
    val errorLiveData: LiveData<Throwable> get() = _errorLiveData

    suspend fun getData() {
        val useCase = GetStreamsFlowUseCase(repo)
        useCase.run().onEach {
            when (it) {
                is ResultData.Loading -> {
                    _loadingLiveData.value = true
                }
                is ResultData.Success -> {
                    val e = it.data.take(20)
                    _successLiveData.value = e.toMutableList()
                    _loadingLiveData.value = false
                }
                is ResultData.Message -> {
                    _messageLiveData.value = it.message
                    _loadingLiveData.value = false
                }
                is ResultData.Error -> {
                    _errorLiveData.value = it.error
                    _loadingLiveData.value = false
                }
            }
        }.launchIn(viewModelScope)
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}