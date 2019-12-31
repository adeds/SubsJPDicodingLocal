package ade.dicoding.sub2.util

import ade.dicoding.sub2.data.model.MovieDetail
import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.data.model.TVDetail
import ade.dicoding.sub2.data.model.Tivies
import android.app.Application
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

class FakeDummy(private val application: Application?) {

    fun parsing(fileName: String): String? {
        if (application != null) {
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
        return null
    }

    fun generateMovies(): Movies {
        return Gson().fromJson(parsing("Upcoming"), Movies::class.javaObjectType)
    }

    fun generateTivies(): Tivies {
        return Gson().fromJson(parsing("TVShow"), Tivies::class.javaObjectType)
    }

    fun generateMovieDetail(id: Int): MovieDetail {
        return Gson().fromJson(parsing("$id"), MovieDetail::class.javaObjectType)
    }

    fun generateTVDetail(id: Int): TVDetail {
        return Gson().fromJson(parsing("$id"), TVDetail::class.javaObjectType)
    }
}