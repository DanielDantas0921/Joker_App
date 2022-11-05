package co.tiagoaguiar.tutorial.jokerappdev.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HTTPClient {

    private const val BASE_URL = "https://api.tiagoaguiar.co/jokerapp/"
    const val API_KEY = "82a3faf0-f31b-462d-9e92-a3591c0346d2"

    private fun httpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }


    fun retrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory
            .create()).client(httpClient()).build()

    }


}