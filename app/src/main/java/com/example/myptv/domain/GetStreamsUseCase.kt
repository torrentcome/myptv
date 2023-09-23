package com.example.myptv.domain

import com.example.myptv.data.RepoImpl
import com.example.myptv.domain.base.UseCase
import com.example.myptv.data.model.Stream

class GetStreamsUseCase constructor(private val repo: RepoImpl) : UseCase<List<Stream>, Any?>() {
    override suspend fun run(params: Any?): List<Stream> {
        return repo.getStreams()
    }
}