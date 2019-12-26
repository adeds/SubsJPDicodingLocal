package ade.dicoding.sub2.util

import ade.dicoding.sub2.data.model.MovieDetail
import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.data.model.TVDetail
import ade.dicoding.sub2.data.model.Tivies
import android.app.Application
import android.util.Log
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

class FakeDummy(private val application: Application) {

    fun parsing(fileName: String): String? {
        return try {
            val `is`: InputStream = application.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun generateMovies(): Movies {
        val movies = Gson().fromJson(parsing("Upcoming"), Movies::class.javaObjectType)
        return movies
    }

    fun generateTivies(): Tivies {
        val tivies = Gson().fromJson(parsing("TVShow"), Tivies::class.javaObjectType)
        return tivies
    }

    fun generateMovieDetail(id: Int): MovieDetail {
        val movie = Gson().fromJson(parsing("$id"), MovieDetail::class.javaObjectType)
        return movie
    }

    fun generateTVDetail(id: Int): TVDetail {
        val movie = Gson().fromJson(parsing("$id"), TVDetail::class.javaObjectType)
        return movie
    }
}