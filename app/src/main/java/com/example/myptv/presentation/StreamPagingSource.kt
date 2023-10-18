package com.example.myptv.presentation

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.myptv.data.Repo
import com.example.myptv.domain.model.Stream

class StreamPagingSource(
    private val repo: Repo
) : PagingSource<Int, Stream>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Stream> {
        val page = params.key ?: 0

        return try {
            val entities = repo.getPagedList(params.loadSize, page * params.loadSize)
            LoadResult.Page(
                data = entities,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (entities.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Stream>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}