package ade.dicoding.sub2.helper

import androidx.sqlite.db.SimpleSQLiteQuery


object SortUtils {
    const val NEWEST = "Terbaru"
    const val OLDEST = "Terlama"
    const val ASCENDING = "A-Z"
    const val DESC = "Z-A"
    fun getSorteredMovie(filter: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * from moviedetail ")
        when (filter) {
            NEWEST -> simpleQuery.append("WHERE is_favorites != 0 ORDER BY is_favorites DESC")
            OLDEST -> simpleQuery.append("WHERE is_favorites != 0 ORDER BY is_favorites ASC")
            ASCENDING -> simpleQuery.append("WHERE is_favorites != 0 ORDER BY title ASC")
            DESC -> simpleQuery.append("WHERE is_favorites != 0 ORDER BY title DESC")
            else -> simpleQuery.append("WHERE is_favorites != 0 AND title LIKE '%${filter}%'")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }

    fun getSorteredTV(filter: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * from tvdetail ")
        when (filter) {
            NEWEST -> simpleQuery.append("WHERE is_favorites != 0 ORDER BY is_favorites DESC")
            OLDEST -> simpleQuery.append("WHERE is_favorites != 0 ORDER BY is_favorites ASC")
            ASCENDING -> simpleQuery.append("WHERE is_favorites != 0 ORDER BY title ASC")
            DESC -> simpleQuery.append("WHERE is_favorites != 0 ORDER BY title DESC")
            else -> simpleQuery.append("WHERE is_favorites != 0 AND title LIKE '%${filter}%'")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}