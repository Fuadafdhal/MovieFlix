package com.afdhal_fa.submissionjetpack.utils

import android.content.Context
import android.util.Log
import com.afdhal_fa.submissionjetpack.R
import com.afdhal_fa.submissionjetpack.model.MovieEntity
import org.json.JSONObject
import java.io.InputStream


object DataDummy {
    fun generateDummyMovie(mContext: Context): List<MovieEntity> {
        val mMoviesEntity = ArrayList<MovieEntity>()

        val mInputStream: InputStream =
            mContext.getResources().openRawResource(R.raw.movies_data)
        try {
            val json = mInputStream.bufferedReader().use { it.readText() }
            Log.d("DataDummy", "DataDummy: $json")
            val jsonObject = JSONObject(json)
            val dataArray = jsonObject.getJSONArray("movies")
            for (i in 0 until dataArray.length()) {
                val mMovieObject: JSONObject = dataArray.getJSONObject(i)

                val id = mMovieObject.getString("id")
                val title = mMovieObject.getString("title")
                val overview = mMovieObject.getString("overview")
                val poster = mMovieObject.getString("poster")
                val language = mMovieObject.getString("language")
                val runtime = mMovieObject.getString("runtime")
                val gendre = mMovieObject.getString("gendre")

                val _mMovieEntity =
                    MovieEntity(id, title, overview, poster, language, runtime, gendre)

                mMoviesEntity.add(_mMovieEntity)
            }
        } finally {
            mInputStream.close()
        }
        return mMoviesEntity
    }

    fun generateDummyTVShow(mContext: Context): List<MovieEntity> {
        val mMoviesEntity = ArrayList<MovieEntity>()

        val mInputStream: InputStream =
            mContext.getResources().openRawResource(R.raw.movies_data)
        try {
            val json = mInputStream.bufferedReader().use { it.readText() }
            Log.d("DataDummy", "DataDummy: $json")
            val jsonObject = JSONObject(json)
            val dataArray = jsonObject.getJSONArray("tv_show")
            for (i in 0 until dataArray.length()) {
                val mMovieObject: JSONObject = dataArray.getJSONObject(i)

                val id = mMovieObject.getString("id")
                val title = mMovieObject.getString("title")
                val overview = mMovieObject.getString("overview")
                val poster = mMovieObject.getString("poster")
                val language = mMovieObject.getString("language")
                val runtime = mMovieObject.getString("runtime")
                val gendre = mMovieObject.getString("gendre")

                val _mMovieEntity =
                    MovieEntity(id, title, overview, poster, language, runtime, gendre)

                mMoviesEntity.add(_mMovieEntity)
            }
        } finally {
            mInputStream.close()
        }
        return mMoviesEntity
    }

}