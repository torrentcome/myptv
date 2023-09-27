package com.example.myptv.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myptv.domain.model.Stream
import com.example.myptv.domain.GetStreamsUseCase
import com.example.myptv.presentation.base.UseCaseResponse
import kotlinx.coroutines.cancel

class StreamsViewModel constructor(private val getStreamsUseCase: GetStreamsUseCase) : ViewModel() {
    companion object {
        private val TAG = StreamsViewModel::class.java.name
    }

    val streamsData = MutableLiveData<List<Stream>>()
    val messageData = MutableLiveData<String>()

    fun getStreams() {
        getStreamsUseCase.invoke(
            viewModelScope, null,
            object : UseCaseResponse<List<Stream>> {
                override fun onSuccess(result: List<Stream>) {
                    Log.i(TAG, "result size ${result.size}")
                    streamsData.value = result
                }

                override fun onError(exception: Exception?) {
                    messageData.value = exception?.message
                    Log.i(TAG, "error : ${exception?.message}")
                }
            },
        )
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}