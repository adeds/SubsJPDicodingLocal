package ade.dicoding.sub2.network

import ade.dicoding.sub2.BuildConfig.TOKEN
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitBuilder {

    private var baseUrl: String = "https://api.themoviedb.org/"
    private var timeOut: Long = 20

    fun baseUrl(baseUrl: String): RetrofitBuilder {
        this.baseUrl = baseUrl
        return this
    }

    fun timeOut(inSecond: Long): RetrofitBuilder {
        this.timeOut = inSecond
        return this
    }

    fun build(): Retrofit {

        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
            .authenticator(RetrofitAuthenticator())
            .writeTimeout(timeOut, TimeUnit.SECONDS)
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .addInterceptor(logInterceptor)
            .addInterceptor { chain ->
                val request = chain.request()

                val originalUrl = request.url()
                val url = originalUrl.newBuilder()
                    .addQueryParameter("api_key", TOKEN)
                    .build()
                val reqBuilder = request.newBuilder().url(url)
                val response = chain.proceed(reqBuilder.build())
                response
            }
            .build()

        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
    }
}
