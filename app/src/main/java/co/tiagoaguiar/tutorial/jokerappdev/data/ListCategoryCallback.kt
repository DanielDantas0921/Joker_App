package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.model.Category

interface ListCategoryCallback {

        fun onSuccess(response: List<String>)

        fun onError(response: String)

        fun onComplete()

}