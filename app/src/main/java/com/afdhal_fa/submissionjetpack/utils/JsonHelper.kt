package com.afdhal_fa.submissionjetpack.utils

import android.content.Context
import com.afdhal_fa.submissionjetpack.R
import com.afdhal_fa.submissionjetpack.data.source.remote.response.MovieResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    @Suppress("SameParameterValue")
    private fun parsingFileToString(fileName: Int): String? {
        return try {
            val `is` = context.resources.openRawResource(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie(): ArrayList<MovieResponse> {
        val resultMovies = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString(R.raw.movies_data).toString())
            val dataArray = responseObject.getJSONArray("movies")
            for (i in 0 until dataArray.length()) {
                val _movie = dataArray.getJSONObject(i)

                val id = _movie.getString("id")
                val title = _movie.getString("title")
                val overview = _movie.getString("overview")
                val poster = _movie.getString("poster")
                val language = _movie.getString("language")
                val runtime = _movie.getString("runtime")
                val gendre = _movie.getString("gendre")
                val movie = MovieResponse(id, title, overview, poster, language, runtime, gendre)

                resultMovies.add(movie)
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return resultMovies
    }

    fun loadMovieByID(_id: String): MovieResponse {
        var resultMovies: MovieResponse? = null
        try {
            val responseObject = JSONObject(parsingFileToString(R.raw.movies_data).toString())
            val dataArray = responseObject.getJSONArray("movies")
            for (i in 0 until dataArray.length()) {
                val _movie = dataArray.getJSONObject(i)
                val id = _movie.getString("id")
                if (id == _id) {
                    val title = _movie.getString("title")
                    val overview = _movie.getString("overview")
                    val poster = _movie.getString("poster")
                    val language = _movie.getString("language")
                    val runtime = _movie.getString("runtime")
                    val gendre = _movie.getString("gendre")
                    resultMovies = MovieResponse(id, title, overview, poster, language, runtime, gendre)
                    return resultMovies
                }
            }

        } catch (e: JSONException) {
            e.printStackTrace()
            resultMovies = MovieResponse("", "", "", "", "", "", "")
        }
        return resultMovies!!
    }

    fun loadTVShow(): ArrayList<MovieResponse> {
        val resultTVShow = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString(R.raw.movies_data).toString())
            val dataArray = responseObject.getJSONArray("tv_show")
            for (i in 0 until dataArray.length()) {
                val _movie = dataArray.getJSONObject(i)

                val id = _movie.getString("id")
                val title = _movie.getString("title")
                val overview = _movie.getString("overview")
                val poster = _movie.getString("poster")
                val language = _movie.getString("language")
                val runtime = _movie.getString("runtime")
                val gendre = _movie.getString("gendre")
                val movie = MovieResponse(id, title, overview, poster, language, runtime, gendre)

                resultTVShow.add(movie)
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return resultTVShow
    }

    fun loadTVShowByID(_id: String): MovieResponse {
        var resultMovies: MovieResponse? = null
        try {
            val responseObject = JSONObject(parsingFileToString(R.raw.movies_data).toString())
            val dataArray = responseObject.getJSONArray("tv_show")
            for (i in 0 until dataArray.length()) {
                val _movie = dataArray.getJSONObject(i)
                val id = _movie.getString("id")
                if (id == _id) {
                    val title = _movie.getString("title")
                    val overview = _movie.getString("overview")
                    val poster = _movie.getString("poster")
                    val language = _movie.getString("language")
                    val runtime = _movie.getString("runtime")
                    val gendre = _movie.getString("gendre")
                    resultMovies = MovieResponse(id, title, overview, poster, language, runtime, gendre)
                    return resultMovies
                }
            }

        } catch (e: JSONException) {
            e.printStackTrace()
            resultMovies = MovieResponse("", "", "", "", "", "", "")
        }
        return resultMovies!!
    }
}