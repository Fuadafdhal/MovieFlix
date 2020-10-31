package com.afdhal_fa.submissionjetpack.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity
import com.afdhal_fa.submissionjetpack.data.source.local.entity.TVShowEntity
import com.afdhal_fa.submissionjetpack.domain.model.Movie
import com.dicoding.academies.vo.Resource

object DataMaperTest {

    fun mapMovieEntityToMoviePagedList(input: MutableLiveData<Resource<PagedList<MovieEntity>>>): LiveData<Resource<PagedList<Movie>>> {
        input.value?.data.dataSource
        return
    }

    fun mapTVShowEntityToTVShowPagedList(input: DataSource.Factory<Int, TVShowEntity>): LiveData<PagedList<Movie>> {

        val config = PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(4).setPageSize(4).build()

        val result = LivePagedListBuilder(input.map {
            Movie(
                id = it.id, title = it.title, overview = it.overview, poster = it.poster, language = it.language, runtime = it.runtime,
                gendre = it.gendre, favorite = it.favorite
            )
        }, config).build()

        return result
    }
}