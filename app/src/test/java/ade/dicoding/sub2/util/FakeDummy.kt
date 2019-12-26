package ade.dicoding.sub2.util

import ade.dicoding.sub2.data.model.MovieDetail
import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.data.model.Tivies
import com.google.gson.Gson

class FakeDummy {
    fun generateMovies(): Movies {
        val movies = Gson().fromJson(mockResponseMovie, Movies::class.javaObjectType)
        return movies
    }

    fun generateTivies(): Tivies {
        val tivies = Gson().fromJson(mockResponseTV, Tivies::class.javaObjectType)
        return tivies
    }

    fun generateMovieDetail(): MovieDetail {
        val movie = Gson().fromJson(mockMovieDetail, MovieDetail::class.javaObjectType)
        return movie
    }

    private val mockMovieDetail = "{\n" +
            "  \"adult\": false,\n" +
            "  \"backdrop_path\": \"/dCB7d4l0mfpsISZvr6aPE2z5QF6.jpg\",\n" +
            "  \"belongs_to_collection\": {\n" +
            "    \"id\": 10,\n" +
            "    \"name\": \"Star Wars Collection\",\n" +
            "    \"poster_path\": \"/iTQHKziZy9pAAY4hHEDCGPaOvFC.jpg\",\n" +
            "    \"backdrop_path\": \"/d8duYyyC9J5T825Hg7grmaabfxQ.jpg\"\n" +
            "  },\n" +
            "  \"budget\": 250000000,\n" +
            "  \"genres\": [\n" +
            "    {\n" +
            "      \"id\": 28,\n" +
            "      \"name\": \"Action\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 12,\n" +
            "      \"name\": \"Adventure\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 878,\n" +
            "      \"name\": \"Science Fiction\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"homepage\": \"https://www.starwars.com/films/star-wars-episode-ix-the-rise-of-skywalker\",\n" +
            "  \"id\": 181812,\n" +
            "  \"imdb_id\": \"tt2527338\",\n" +
            "  \"original_language\": \"en\",\n" +
            "  \"original_title\": \"Star Wars: The Rise of Skywalker\",\n" +
            "  \"overview\": \"The surviving Resistance faces the First Order once again as the journey of Rey, Finn and Poe Dameron continues. With the power and knowledge of generations behind them, the final battle begins.\",\n" +
            "  \"popularity\": 608.26,\n" +
            "  \"poster_path\": \"/db32LaOibwEliAmSL2jjDF6oDdj.jpg\",\n" +
            "  \"production_companies\": [\n" +
            "    {\n" +
            "      \"id\": 1,\n" +
            "      \"logo_path\": \"/o86DbpburjxrqAzEDhXZcyE8pDb.png\",\n" +
            "      \"name\": \"Lucasfilm\",\n" +
            "      \"origin_country\": \"US\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 11461,\n" +
            "      \"logo_path\": \"/p9FoEt5shEKRWRKVIlvFaEmRnun.png\",\n" +
            "      \"name\": \"Bad Robot\",\n" +
            "      \"origin_country\": \"US\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 2,\n" +
            "      \"logo_path\": \"/wdrCwmRnLFJhEoH8GSfymY85KHT.png\",\n" +
            "      \"name\": \"Walt Disney Pictures\",\n" +
            "      \"origin_country\": \"US\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"production_countries\": [\n" +
            "    {\n" +
            "      \"iso_3166_1\": \"US\",\n" +
            "      \"name\": \"United States of America\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"release_date\": \"2019-12-18\",\n" +
            "  \"revenue\": 0,\n" +
            "  \"runtime\": 142,\n" +
            "  \"spoken_languages\": [\n" +
            "    {\n" +
            "      \"iso_639_1\": \"en\",\n" +
            "      \"name\": \"English\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"Released\",\n" +
            "  \"tagline\": \"Every generation has a legend\",\n" +
            "  \"title\": \"Star Wars: The Rise of Skywalker\",\n" +
            "  \"video\": false,\n" +
            "  \"vote_average\": 6.8,\n" +
            "  \"vote_count\": 639\n" +
            "}"
    private val mockResponseTV = "{\n" +
            "  \"page\": 1,\n" +
            "  \"total_results\": 259,\n" +
            "  \"total_pages\": 13,\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"original_name\": \"The Mandalorian\",\n" +
            "      \"genre_ids\": [\n" +
            "        10759,\n" +
            "        10765\n" +
            "      ],\n" +
            "      \"name\": \"The Mandalorian\",\n" +
            "      \"popularity\": 494.012,\n" +
            "      \"origin_country\": [\n" +
            "        \"US\"\n" +
            "      ],\n" +
            "      \"vote_count\": 322,\n" +
            "      \"first_air_date\": \"2019-11-12\",\n" +
            "      \"backdrop_path\": \"/o7qi2v4uWQ8bZ1tW3KI0Ztn2epk.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"id\": 82856,\n" +
            "      \"vote_average\": 7.9,\n" +
            "      \"overview\": \"\",\n" +
            "      \"poster_path\": \"/BbNvKCuEF4SRzFXR16aK6ISFtR.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"original_name\": \"His Dark Materials\",\n" +
            "      \"genre_ids\": [\n" +
            "        18,\n" +
            "        10765\n" +
            "      ],\n" +
            "      \"name\": \"His Dark Materials\",\n" +
            "      \"popularity\": 180.089,\n" +
            "      \"origin_country\": [\n" +
            "        \"GB\"\n" +
            "      ],\n" +
            "      \"vote_count\": 123,\n" +
            "      \"first_air_date\": \"2019-11-03\",\n" +
            "      \"backdrop_path\": \"/9yKCJTOh9m3Lol2RY3kw99QPH6x.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"id\": 68507,\n" +
            "      \"vote_average\": 7.5,\n" +
            "      \"overview\": \"\",\n" +
            "      \"poster_path\": \"/xOjRNnQw5hqR1EULJ2iHkGwJVA4.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"original_name\": \"Shameless\",\n" +
            "      \"genre_ids\": [\n" +
            "        35,\n" +
            "        18\n" +
            "      ],\n" +
            "      \"name\": \"Shameless\",\n" +
            "      \"popularity\": 104.404,\n" +
            "      \"origin_country\": [\n" +
            "        \"US\"\n" +
            "      ],\n" +
            "      \"vote_count\": 934,\n" +
            "      \"first_air_date\": \"2011-01-09\",\n" +
            "      \"backdrop_path\": \"/1ccgQ6IJyEc8UHPtGeFFeRqMVnc.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"id\": 34307,\n" +
            "      \"vote_average\": 7.9,\n" +
            "      \"overview\": \"\",\n" +
            "      \"poster_path\": \"/7eDvhKCu7jkkKQI37nwYWvXJTzl.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"original_name\": \"Mr. Robot\",\n" +
            "      \"genre_ids\": [\n" +
            "        80,\n" +
            "        18\n" +
            "      ],\n" +
            "      \"name\": \"Mr. Robot\",\n" +
            "      \"popularity\": 64.665,\n" +
            "      \"origin_country\": [\n" +
            "        \"US\"\n" +
            "      ],\n" +
            "      \"vote_count\": 1639,\n" +
            "      \"first_air_date\": \"2015-05-27\",\n" +
            "      \"backdrop_path\": \"/4n0TZfTUSUELqRrOA8sZKWs9bWU.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"id\": 62560,\n" +
            "      \"vote_average\": 7.9,\n" +
            "      \"overview\": \"\",\n" +
            "      \"poster_path\": \"/esN3gWb1P091xExLddD2nh4zmi3.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"original_name\": \"Ray Donovan\",\n" +
            "      \"genre_ids\": [\n" +
            "        18\n" +
            "      ],\n" +
            "      \"name\": \"Ray Donovan\",\n" +
            "      \"popularity\": 58.838,\n" +
            "      \"origin_country\": [\n" +
            "        \"US\"\n" +
            "      ],\n" +
            "      \"vote_count\": 409,\n" +
            "      \"first_air_date\": \"2013-06-30\",\n" +
            "      \"backdrop_path\": \"/ijX8tWeMBMPwEPKNpSavyd9334r.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"id\": 1423,\n" +
            "      \"vote_average\": 7.4,\n" +
            "      \"overview\": \"\",\n" +
            "      \"poster_path\": \"/v937VN30n6WKICNUw02n8Brjbvk.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"original_name\": \"Harley Quinn\",\n" +
            "      \"genre_ids\": [\n" +
            "        16,\n" +
            "        35,\n" +
            "        80\n" +
            "      ],\n" +
            "      \"name\": \"Harley Quinn\",\n" +
            "      \"popularity\": 50.53,\n" +
            "      \"origin_country\": [\n" +
            "        \"US\"\n" +
            "      ],\n" +
            "      \"vote_count\": 23,\n" +
            "      \"first_air_date\": \"2019-11-29\",\n" +
            "      \"backdrop_path\": \"/29cFVNndxhmE5mmhEmYm4G32HHm.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"id\": 74440,\n" +
            "      \"vote_average\": 8.4,\n" +
            "      \"overview\": \"\",\n" +
            "      \"poster_path\": \"/2qZwqQzm9GfxamposgXrX7dLKcF.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"original_name\": \"Sesame Street\",\n" +
            "      \"genre_ids\": [\n" +
            "        16,\n" +
            "        35,\n" +
            "        10751\n" +
            "      ],\n" +
            "      \"name\": \"Sesame Street\",\n" +
            "      \"popularity\": 44.361,\n" +
            "      \"origin_country\": [\n" +
            "        \"US\"\n" +
            "      ],\n" +
            "      \"vote_count\": 95,\n" +
            "      \"first_air_date\": \"1969-11-10\",\n" +
            "      \"backdrop_path\": \"/zIbkxRfoDXj9cOcQSFjB9yDHwj.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"id\": 502,\n" +
            "      \"vote_average\": 7.2,\n" +
            "      \"overview\": \"\",\n" +
            "      \"poster_path\": \"/aM2VEnR05ssgmafDGNFngJWyOrC.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"original_name\": \"Servant\",\n" +
            "      \"genre_ids\": [\n" +
            "        18\n" +
            "      ],\n" +
            "      \"name\": \"Servant\",\n" +
            "      \"popularity\": 46.376,\n" +
            "      \"origin_country\": [\n" +
            "        \"US\"\n" +
            "      ],\n" +
            "      \"vote_count\": 22,\n" +
            "      \"first_air_date\": \"2019-11-28\",\n" +
            "      \"backdrop_path\": \"/digxxEISFHSPOLpBFbZnQqm9nhD.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"id\": 88055,\n" +
            "      \"vote_average\": 8,\n" +
            "      \"overview\": \"\",\n" +
            "      \"poster_path\": \"/n5iDow3TLI74e0W41363ieKucei.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"original_name\": \"僕のヒーローアカデミア\",\n" +
            "      \"id\": 65930,\n" +
            "      \"name\": \"僕のヒーローアカデミア\",\n" +
            "      \"popularity\": 40.967,\n" +
            "      \"vote_count\": 207,\n" +
            "      \"vote_average\": 8,\n" +
            "      \"first_air_date\": \"2016-04-03\",\n" +
            "      \"poster_path\": \"/lr19Qj2kP7XIicmbMMKTZ6aoQFL.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        10759,\n" +
            "        16,\n" +
            "        35\n" +
            "      ],\n" +
            "      \"original_language\": \"ja\",\n" +
            "      \"backdrop_path\": \"/r1jOpRyqP5pKkvZvaiCXVJ5RYOa.jpg\",\n" +
            "      \"overview\": \"\",\n" +
            "      \"origin_country\": [\n" +
            "        \"JP\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"original_name\": \"Lost in Space\",\n" +
            "      \"id\": 75758,\n" +
            "      \"name\": \"Lost in Space\",\n" +
            "      \"popularity\": 45.374,\n" +
            "      \"vote_count\": 263,\n" +
            "      \"vote_average\": 6.9,\n" +
            "      \"first_air_date\": \"2018-04-13\",\n" +
            "      \"poster_path\": \"/y8NJnTXzb4rio9uvVYFVrXEMofU.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        10765,\n" +
            "        10759,\n" +
            "        18\n" +
            "      ],\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"backdrop_path\": \"/tJAGIHi7tzyVwOhfuoLkJPubj3b.jpg\",\n" +
            "      \"overview\": \"\",\n" +
            "      \"origin_country\": [\n" +
            "        \"US\"\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}"
    private val mockResponseMovie = "{\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"popularity\": 608.26,\n" +
            "      \"vote_count\": 614,\n" +
            "      \"video\": false,\n" +
            "      \"poster_path\": \"/db32LaOibwEliAmSL2jjDF6oDdj.jpg\",\n" +
            "      \"id\": 181812,\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/dCB7d4l0mfpsISZvr6aPE2z5QF6.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Star Wars: The Rise of Skywalker\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        12,\n" +
            "        878\n" +
            "      ],\n" +
            "      \"title\": \"Star Wars: The Rise of Skywalker\",\n" +
            "      \"vote_average\": 6.8,\n" +
            "      \"overview\": \"\",\n" +
            "      \"release_date\": \"2019-12-18\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"popularity\": 242.153,\n" +
            "      \"vote_count\": 402,\n" +
            "      \"video\": false,\n" +
            "      \"poster_path\": \"/jyw8VKYEiM1UDzPB7NsisUgBeJ8.jpg\",\n" +
            "      \"id\": 512200,\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/zTxHf9iIOCqRbxvl8W5QYKrsMLq.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Jumanji: The Next Level\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        12,\n" +
            "        35,\n" +
            "        14\n" +
            "      ],\n" +
            "      \"title\": \"Jumanji: The Next Level\",\n" +
            "      \"vote_average\": 6.7,\n" +
            "      \"overview\": \"\",\n" +
            "      \"release_date\": \"2019-12-04\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"popularity\": 183.526,\n" +
            "      \"vote_count\": 1150,\n" +
            "      \"video\": false,\n" +
            "      \"poster_path\": \"/pjeMs3yqRmFL3giJy4PMXWZTTPa.jpg\",\n" +
            "      \"id\": 330457,\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/xJWPZIYOEFIjZpBL7SVBGnzRYXp.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Frozen II\",\n" +
            "      \"genre_ids\": [\n" +
            "        12,\n" +
            "        16,\n" +
            "        10402,\n" +
            "        10751\n" +
            "      ],\n" +
            "      \"title\": \"Frozen II\",\n" +
            "      \"vote_average\": 7,\n" +
            "      \"overview\": \"\",\n" +
            "      \"release_date\": \"2019-11-20\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"popularity\": 139.93,\n" +
            "      \"vote_count\": 57,\n" +
            "      \"video\": false,\n" +
            "      \"poster_path\": \"/MBiKqTsouYqAACLYNDadsjhhC0.jpg\",\n" +
            "      \"id\": 486589,\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/bga3i5jcejBekr2FCGJga1fYCh.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Red Shoes and the Seven Dwarfs\",\n" +
            "      \"genre_ids\": [\n" +
            "        16,\n" +
            "        10749\n" +
            "      ],\n" +
            "      \"title\": \"Red Shoes and the Seven Dwarfs\",\n" +
            "      \"vote_average\": 6.1,\n" +
            "      \"overview\": \"\",\n" +
            "      \"release_date\": \"2019-07-25\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"popularity\": 308.809,\n" +
            "      \"vote_count\": 29,\n" +
            "      \"video\": false,\n" +
            "      \"poster_path\": \"/mAWBfTDAmfpvQGMVFuzuVl49N1P.jpg\",\n" +
            "      \"id\": 449924,\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/ekP6EVxL81lZ4ivcqPsoZ72rY0h.jpg\",\n" +
            "      \"original_language\": \"cn\",\n" +
            "      \"original_title\": \"葉問4\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        18,\n" +
            "        36\n" +
            "      ],\n" +
            "      \"title\": \"葉問4\",\n" +
            "      \"vote_average\": 5.7,\n" +
            "      \"overview\": \"\",\n" +
            "      \"release_date\": \"2019-12-20\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"popularity\": 73.075,\n" +
            "      \"id\": 546554,\n" +
            "      \"video\": false,\n" +
            "      \"vote_count\": 767,\n" +
            "      \"vote_average\": 7.9,\n" +
            "      \"title\": \"Knives Out\",\n" +
            "      \"release_date\": \"2019-11-27\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Knives Out\",\n" +
            "      \"genre_ids\": [\n" +
            "        9648,\n" +
            "        53,\n" +
            "        35\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/AbRYlvwAKHs0YuyNO6NX9ofq4l6.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"\",\n" +
            "      \"poster_path\": \"/pThyQovXQrw2m0s9x82twj48Jq4.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"popularity\": 68.982,\n" +
            "      \"vote_count\": 1854,\n" +
            "      \"video\": false,\n" +
            "      \"poster_path\": \"/tcmj4YQ6p79OD8ECpRAbV8Yjk0c.jpg\",\n" +
            "      \"id\": 496243,\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/TU9NIjwzjoKPwQHoHshkFcQUCG.jpg\",\n" +
            "      \"original_language\": \"ko\",\n" +
            "      \"original_title\": \"기생충\",\n" +
            "      \"genre_ids\": [\n" +
            "        35,\n" +
            "        53\n" +
            "      ],\n" +
            "      \"title\": \"Parasite\",\n" +
            "      \"vote_average\": 8.6,\n" +
            "      \"overview\": \"Semua menganggur, keluarga Ki-taek memiliki minat khusus pada Taman kaya dan glamor untuk mata pencaharian mereka sampai mereka terjerat dalam insiden tak terduga.\",\n" +
            "      \"release_date\": \"2019-05-30\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"popularity\": 49.351,\n" +
            "      \"vote_count\": 7,\n" +
            "      \"video\": false,\n" +
            "      \"poster_path\": \"/gbPfvwBqbiHpQkYZQvVwB6MVauV.jpg\",\n" +
            "      \"id\": 525661,\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/ghQrKrcEpAlkzBuNoOCSxHQXWqw.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Bombshell\",\n" +
            "      \"genre_ids\": [\n" +
            "        18\n" +
            "      ],\n" +
            "      \"title\": \"Bombshell\",\n" +
            "      \"vote_average\": 6.3,\n" +
            "      \"overview\": \"\",\n" +
            "      \"release_date\": \"2019-12-13\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"popularity\": 58.173,\n" +
            "      \"vote_count\": 14,\n" +
            "      \"video\": false,\n" +
            "      \"poster_path\": \"/9zvjgr1v8pwFYQNHZTtnKNQUWmw.jpg\",\n" +
            "      \"id\": 536869,\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/4F8M02OjkfDIIBg36R5ZluLK2nU.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Cats\",\n" +
            "      \"genre_ids\": [\n" +
            "        35,\n" +
            "        18,\n" +
            "        14,\n" +
            "        10402\n" +
            "      ],\n" +
            "      \"title\": \"Cats\",\n" +
            "      \"vote_average\": 5.2,\n" +
            "      \"overview\": \"\",\n" +
            "      \"release_date\": \"2019-11-26\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"popularity\": 61.737,\n" +
            "      \"vote_count\": 3,\n" +
            "      \"video\": false,\n" +
            "      \"poster_path\": \"/z52xI0MnoX1rqySFJYnmBqHbXRn.jpg\",\n" +
            "      \"id\": 431693,\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/nZ1N5tDpoNm8UJBmWGoTZCRiDoQ.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Spies in Disguise\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        12,\n" +
            "        16\n" +
            "      ],\n" +
            "      \"title\": \"Spies in Disguise\",\n" +
            "      \"vote_average\": 8,\n" +
            "      \"overview\": \"\",\n" +
            "      \"release_date\": \"2019-12-24\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"page\": 1,\n" +
            "  \"total_results\": 204,\n" +
            "  \"dates\": {\n" +
            "    \"maximum\": \"2020-01-12\",\n" +
            "    \"minimum\": \"2019-12-28\"\n" +
            "  },\n" +
            "  \"total_pages\": 11\n" +
            "}"
}