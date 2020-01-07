package ade.dicoding.sub2.data.model


import com.google.gson.annotations.SerializedName

data class MovieDetail(
    @SerializedName("genres")
    var genres: List<Genre?>? = null,

    @SerializedName("homepage")
    var homepage: String? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("original_title")
    var title: String? = null,

    @SerializedName("overview")
    var overview: String? = null,

    @SerializedName("popularity")
    var popularity: Double? = null,

    @SerializedName("poster_path")
    var posterPath: String? = null,

    @SerializedName("release_date")
    var releaseDate: String? = null,

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("tagline")
    var tagline: String? = null,

    var isFavorite: Long = 0
) {

    data class Genre(
        @SerializedName("name")
        var name: String? = null
    )
}