package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApi {


    @GET("jokes/categories")
    fun findAllCategories(@Query("apiKey") apiKey: String): Call<List<String>>

    @GET("jokes/random")
    fun findBy(@Query("category") categoryName: String? = null, @Query("apiKey") apiKey: String = HTTPClient.API_KEY) : Call<Joke>


    @GET("jokes/random/")
    fun findRandom(@Query("apiKey") apiKey: String): Call<Joke>

}

