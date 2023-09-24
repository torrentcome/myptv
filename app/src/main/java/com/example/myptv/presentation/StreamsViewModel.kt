package com.example.myptv.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myptv.presentation.base.UseCaseResponse
import com.example.myptv.data.model.Stream
import com.example.myptv.domain.GetStreamsUseCase
import kotlinx.coroutines.cancel
import java.lang.Exception

class StreamsViewModel constructor(private val getStreamsUseCase: GetStreamsUseCase) : ViewModel() {
    companion object {
        private val TAG = StreamsViewModel::class.java.name
    }

    val streamsData = MutableLiveData<List<Stream>>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getStreams() {
        showProgressbar.value = true
        getStreamsUseCase.invoke(viewModelScope, null, object : UseCaseResponse<List<Stream>> {
                override fun onSuccess(result: List<Stream>) {
                    Log.i(TAG, "result size ${result.size}")
                    Log.i(TAG, "result: $result")
                    streamsData.value = result.subList(0, 20)
                    //showProgressbar.value = false
                }

                override fun onError(exception: Exception?) {
                    messageData.value = exception?.message
                    Log.i(TAG, "error : ${exception?.message}")
                    // showProgressbar.value = false
                }
            },
        )
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}