package ade.dicoding.sub2.data.model


import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("results")
    var results: List<Result?>? = null
) {
    data class Result(
        @SerializedName("popularity")
        var popularity: Double? = null,

        @SerializedName("poster_path")
        var posterPath: String? = null,

        @SerializedName("id")
        var id: Int? = null,

        @SerializedName("backdrop_path")
        var backdropPath: String? = null,

        @SerializedName("title")
        var title: String? = null,

        @SerializedName("overview")
        var overview: String? = null,

        @SerializedName("release_date")
        var releaseDate: String? = null)

}