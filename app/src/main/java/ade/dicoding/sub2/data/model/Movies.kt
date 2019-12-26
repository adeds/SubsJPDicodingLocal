package ade.dicoding.sub2.data.model


import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("results")
    var results: List<Result?>? = null,
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("total_results")
    var totalResults: Int? = null,
    @SerializedName("dates")
    var dates: Dates? = null,
    @SerializedName("total_pages")
    var totalPages: Int? = null
) {
    data class Result(
        @SerializedName("popularity")
        var popularity: Double? = null,
        @SerializedName("vote_count")
        var voteCount: Int? = null,
        @SerializedName("video")
        var video: Boolean? = null,
        @SerializedName("poster_path")
        var posterPath: String? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("adult")
        var adult: Boolean? = null,
        @SerializedName("backdrop_path")
        var backdropPath: String? = null,
        @SerializedName("original_language")
        var originalLanguage: String? = null,
        @SerializedName("original_title")
        var originalTitle: String? = null,
        @SerializedName("genre_ids")
        var genreIds: List<Int?>? = null,
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("vote_average")
        var voteAverage: Float? = null,
        @SerializedName("overview")
        var overview: String? = null,
        @SerializedName("release_date")
        var releaseDate: String? = null
    )

    data class Dates(
        @SerializedName("maximum")
        var maximum: String? = null,
        @SerializedName("minimum")
        var minimum: String? = null
    )
}