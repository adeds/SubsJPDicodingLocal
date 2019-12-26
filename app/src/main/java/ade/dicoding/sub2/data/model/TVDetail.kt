package ade.dicoding.sub2.data.model


import com.google.gson.annotations.SerializedName

data class TVDetail(
    @SerializedName("backdrop_path")
    var backdropPath: String? = null,
    @SerializedName("created_by")
    var createdBy: List<CreatedBy?>? = null,
    @SerializedName("episode_run_time")
    var episodeRunTime: List<Int?>? = null,
    @SerializedName("first_air_date")
    var firstAirDate: String? = null,
    @SerializedName("genres")
    var genres: List<Genre?>? = null,
    @SerializedName("homepage")
    var homepage: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("in_production")
    var inProduction: Boolean? = null,
    @SerializedName("languages")
    var languages: List<String?>? = null,
    @SerializedName("last_air_date")
    var lastAirDate: String? = null,
    @SerializedName("last_episode_to_air")
    var lastEpisodeToAir: LastEpisodeToAir? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("next_episode_to_air")
    var nextEpisodeToAir: NextEpisodeToAir? = null,
    @SerializedName("networks")
    var networks: List<Network?>? = null,
    @SerializedName("number_of_episodes")
    var numberOfEpisodes: Int? = null,
    @SerializedName("number_of_seasons")
    var numberOfSeasons: Int? = null,
    @SerializedName("origin_country")
    var originCountry: List<String?>? = null,
    @SerializedName("original_language")
    var originalLanguage: String? = null,
    @SerializedName("original_name")
    var originalName: String? = null,
    @SerializedName("overview")
    var overview: String? = null,
    @SerializedName("popularity")
    var popularity: Double? = null,
    @SerializedName("poster_path")
    var posterPath: String? = null,
    @SerializedName("production_companies")
    var productionCompanies: List<ProductionCompany?>? = null,
    @SerializedName("seasons")
    var seasons: List<Season?>? = null,
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("vote_average")
    var voteAverage: Double? = null,
    @SerializedName("vote_count")
    var voteCount: Int? = null
) {
    data class CreatedBy(
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("credit_id")
        var creditId: String? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("gender")
        var gender: Int? = null,
        @SerializedName("profile_path")
        var profilePath: Any? = null
    )

    data class Genre(
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("name")
        var name: String? = null
    )

    data class LastEpisodeToAir(
        @SerializedName("air_date")
        var airDate: String? = null,
        @SerializedName("episode_number")
        var episodeNumber: Int? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("overview")
        var overview: String? = null,
        @SerializedName("production_code")
        var productionCode: String? = null,
        @SerializedName("season_number")
        var seasonNumber: Int? = null,
        @SerializedName("show_id")
        var showId: Int? = null,
        @SerializedName("still_path")
        var stillPath: String? = null,
        @SerializedName("vote_average")
        var voteAverage: Double? = null,
        @SerializedName("vote_count")
        var voteCount: Int? = null
    )

    data class NextEpisodeToAir(
        @SerializedName("air_date")
        var airDate: String? = null,
        @SerializedName("episode_number")
        var episodeNumber: Int? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("overview")
        var overview: String? = null,
        @SerializedName("production_code")
        var productionCode: String? = null,
        @SerializedName("season_number")
        var seasonNumber: Int? = null,
        @SerializedName("show_id")
        var showId: Int? = null,
        @SerializedName("still_path")
        var stillPath: Any? = null,
        @SerializedName("vote_average")
        var voteAverage: Double? = null,
        @SerializedName("vote_count")
        var voteCount: Int? = null
    )

    data class Network(
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("logo_path")
        var logoPath: String? = null,
        @SerializedName("origin_country")
        var originCountry: String? = null
    )

    data class ProductionCompany(
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("logo_path")
        var logoPath: String? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("origin_country")
        var originCountry: String? = null
    )

    data class Season(
        @SerializedName("episode_count")
        var episodeCount: Int? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("overview")
        var overview: String? = null,
        @SerializedName("poster_path")
        var posterPath: String? = null,
        @SerializedName("season_number")
        var seasonNumber: Int? = null,
        @SerializedName("air_date")
        var airDate: String? = null
    )
}