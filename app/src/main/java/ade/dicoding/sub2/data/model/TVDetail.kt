package ade.dicoding.sub2.data.model


import com.google.gson.annotations.SerializedName

data class TVDetail(
    @SerializedName("created_by")
    var createdBy: List<CreatedBy?>? = null,

    @SerializedName("first_air_date")
    var firstAirDate: String? = null,

    @SerializedName("genres")
    var genres: List<Genre?>? = null,

    @SerializedName("homepage")
    var homepage: String? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("last_air_date")
    var lastAirDate: String? = null,

    @SerializedName("original_name")
    var title: String? = null,

    @SerializedName("overview")
    var overview: String? = null,

    @SerializedName("popularity")
    var popularity: Double? = null,

    @SerializedName("poster_path")
    var posterPath: String? = null,

    @SerializedName("status")
    var status: String? = null

    ) {
    data class CreatedBy(
        @SerializedName("name")
        var name: String? = null

    )

    data class Genre(
        @SerializedName("name")
        var name: String? = null
    )
}