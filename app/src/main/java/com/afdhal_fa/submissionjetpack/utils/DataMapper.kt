package com.afdhal_fa.submissionjetpack.utils

import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity
import com.afdhal_fa.submissionjetpack.data.source.local.entity.TVShowEntity
import com.afdhal_fa.submissionjetpack.domain.model.Movie

object DataMapper {
    fun mapMovieEntityToMovie(input: List<MovieEntity>): List<Movie> {
        val gamesList = ArrayList<Movie>()
        input.map {
            val game = Movie(
                id = it.id, title = it.title, overview = it.overview, poster = it.poster, language = it.language, runtime = it.runtime,
                gendre = it.gendre, favorite = it.favorite
            )
            gamesList.add(game)
        }
        return gamesList
    }

    fun mapTVShowEntityToTVShow(input: List<TVShowEntity>): List<Movie> {
        val gamesList = ArrayList<Movie>()
        input.map {
            val game = Movie(
                id = it.id, title = it.title, overview = it.overview, poster = it.poster, language = it.language, runtime = it.runtime,
                gendre = it.gendre, favorite = it.favorite
            )
            gamesList.add(game)
        }
        return gamesList
    }

    fun mapMovieEntityToMovieByID(it: MovieEntity): Movie {
        return Movie(
            id = it.id, title = it.title, overview = it.overview, poster = it.poster, language = it.language, runtime = it.runtime,
            gendre = it.gendre, favorite = it.favorite
        )
    }

    fun mapTVShowEntityToTVShowByID(it: TVShowEntity): Movie {
        return Movie(
            id = it.id, title = it.title, overview = it.overview, poster = it.poster, language = it.language, runtime = it.runtime,
            gendre = it.gendre, favorite = it.favorite
        )
    }

    fun mapMovieEntityToMovieFavorite(input: List<MovieEntity>): List<Movie> {
        val gamesList = ArrayList<Movie>()
        input.map {
            val game = Movie(
                id = it.id, title = it.title, overview = it.overview, poster = it.poster, language = it.language, runtime = it.runtime,
                gendre = it.gendre, favorite = it.favorite
            )
            gamesList.add(game)
        }
        return gamesList
    }

    fun mapTVShowEntityToTVShowFavorite(input: List<TVShowEntity>): List<Movie> {
        val gamesList = ArrayList<Movie>()
        input.map {
            val game = Movie(
                id = it.id, title = it.title, overview = it.overview, poster = it.poster, language = it.language, runtime = it.runtime,
                gendre = it.gendre, favorite = it.favorite
            )
            gamesList.add(game)
        }
        return gamesList
    }

    fun mapMovieToMovieEntity(input: Movie): MovieEntity {
        return MovieEntity(
            id = input.id, title = input.title, overview = input.overview, poster = input.poster, language = input.language, runtime = input.runtime,
            gendre = input.gendre, favorite = input.favorite
        )
    }

    fun mapTVShowToTVShowEntity(input: Movie): TVShowEntity {
        return TVShowEntity(
            id = input.id, title = input.title, overview = input.overview, poster = input.poster, language = input.language, runtime = input.runtime,
            gendre = input.gendre, favorite = input.favorite
        )
    }


    fun mapMovieToMovieEntitys(input: List<Movie>): List<MovieEntity> {
        val gamesList = ArrayList<MovieEntity>()
        input.map {
            val game = MovieEntity(
                id = it.id, title = it.title, overview = it.overview, poster = it.poster, language = it.language, runtime = it.runtime,
                gendre = it.gendre, favorite = it.favorite
            )
            gamesList.add(game)
        }
        return gamesList
    }

    fun mapTVShowToTVShowEntitys(input: List<Movie>): List<TVShowEntity> {
        val gamesList = ArrayList<TVShowEntity>()
        input.map {
            val game = TVShowEntity(
                id = it.id, title = it.title, overview = it.overview, poster = it.poster, language = it.language, runtime = it.runtime,
                gendre = it.gendre, favorite = it.favorite
            )
            gamesList.add(game)
        }
        return gamesList
    }


    //    fun mapMovieEntityToMoviePagedList(input: DataSource.Factory<Int, MovieEntity>): LiveData<PagedList<Movie>> {
    //
    //        val config = PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(10).setPageSize(10).build()
    //
    //        val result = LivePagedListBuilder(input.map {
    //            Movie(
    //                id = it.id, title = it.title, overview = it.overview, poster = it.poster, language = it.language, runtime = it.runtime,
    //                gendre = it.gendre, favorite = it.favorite
    //            )
    //        }, config).build()
    //
    //        return result
    //    }
    //
    //    fun mapTVShowEntityToTVShowPagedList(input: DataSource.Factory<Int, TVShowEntity>): LiveData<PagedList<Movie>> {
    //
    //        val config = PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(10).setPageSize(10).build()
    //
    //        val result = LivePagedListBuilder(input.map {
    //            Movie(
    //                id = it.id, title = it.title, overview = it.overview, poster = it.poster, language = it.language, runtime = it.runtime,
    //                gendre = it.gendre, favorite = it.favorite
    //            )
    //        }, config).build()
    //
    //        return result
    //    }


}