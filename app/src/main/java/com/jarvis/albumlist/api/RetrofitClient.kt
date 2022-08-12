package com.jarvis.albumlist.api

import com.jarvis.albumlist.App
import com.jarvis.albumlist.R
import com.jarvis.albumlist.api.service.AlbumService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {

    private const val TIME_OUT = 10L

    private val albumApiUrl = App.instance.resources.getString(R.string.ALBUM_BASE_URL)

    val albumApi: AlbumService by lazy { getRetrofitClient() }

    private inline fun <reified T> getRetrofitClient() = Retrofit.Builder()
        .baseUrl(albumApiUrl)
        .addConverterFactory(NullOnEmptyConverterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .client(getOkhttpClient())
        .build()
        .create(T::class.java)


    private fun getOkhttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor)
            connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            readTimeout(TIME_OUT, TimeUnit.SECONDS)
            writeTimeout(TIME_OUT, TimeUnit.SECONDS)
        }.build()
    }
}