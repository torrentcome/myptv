package com.example.myptv.data.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.myptv.data.RepoImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CleanLocalWork(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params), KoinComponent {

    @ExperimentalCoroutinesApi
    override suspend fun doWork(): Result {
        val repository: RepoImpl by inject()
        return try {

            Result.success()
        } catch (err: Exception) {
            Result.failure()
        }
    }
}