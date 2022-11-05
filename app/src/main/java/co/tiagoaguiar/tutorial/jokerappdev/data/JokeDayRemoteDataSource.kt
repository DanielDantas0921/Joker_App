package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeDayRemoteDataSource {


    fun findRandom(callback: JokeDayCallback) {
        HTTPClient.retrofit()
            .create(ChuckNorrisApi::class.java)
            .findRandom(HTTPClient.API_KEY)
            .enqueue(object: Callback<Joke>{
                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {

                    if (response.isSuccessful) {
                        val categories = response.body()
                        callback.onSuccess(categories ?: throw java.lang.RuntimeException("Piada não encontrada"))
                    } else {
                        val error = response.errorBody()?.string()
                        callback.onError(error ?: "Error desconhecido")
                    }

                    callback.onComplete()
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    callback.onError(t.message ?: "Error interno")
                    callback.onComplete()

                }

            })


    }


}