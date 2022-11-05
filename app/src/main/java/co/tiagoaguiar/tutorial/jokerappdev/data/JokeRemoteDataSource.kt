package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeRemoteDataSource() {

    fun findBy(categoryName: String, callback: JokeCallback) {
        HTTPClient.retrofit()
            .create(ChuckNorrisApi::class.java)
            .findBy(categoryName)
            .enqueue(
                object : Callback<Joke> {
                    override fun onResponse(call: Call<Joke>, response: Response<Joke>) {

                        if (response.isSuccessful) {
                            val joke = response.body()
                            callback.onSuccess(joke ?:throw java.lang.RuntimeException("Piada não encontrada"))
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