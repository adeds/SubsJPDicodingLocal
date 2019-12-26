package ade.dicoding.sub2.data.model


import com.google.gson.annotations.SerializedName

data class Tivies(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("total_results")
    var totalResults: Int? = null,
    @SerializedName("total_pages")
    var totalPages: Int? = null,
    @SerializedName("results")
    var results: List<Result?>? = null
) {
    data class Result(
        @SerializedName("original_name")
        var originalName: String? = null,
        @SerializedName("genre_ids")
        var genreIds: List<Int?>? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("popularity")
        var popularity: Double? = null,
        @SerializedName("origin_country")
        var originCountry: List<String?>? = null,
        @SerializedName("vote_count")
        var voteCount: Int? = null,
        @SerializedName("first_air_date")
        var firstAirDate: String? = null,
        @SerializedName("backdrop_path")
        var backdropPath: String? = null,
        @SerializedName("original_language")
        var originalLanguage: String? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("vote_average")
        var voteAverage: Double? = null,
        @SerializedName("overview")
        var overview: String? = null,
        @SerializedName("poster_path")
        var posterPath: String? = null
    )
}