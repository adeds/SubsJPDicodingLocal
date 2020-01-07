package ade.dicoding.sub2.data.model


import com.google.gson.annotations.SerializedName

data class Tivies(
    @SerializedName("results")
    var results: List<Result?>? = null
) {

    data class Result(
        @SerializedName("original_name")
        var title: String? = null,

        @SerializedName("popularity")
        var popularity: Double? = null,

        @SerializedName("first_air_date")
        var firstAirDate: String? = null,

        @SerializedName("backdrop_path")
        var backdropPath: String? = null,

        @SerializedName("id")
        var id: Int? = null,

        @SerializedName("overview")
        var overview: String? = null,

        @SerializedName("poster_path")
        var posterPath: String? = null
    )
}