package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.tutorial.jokerappdev.data.CategoryRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.data.ListCategoryCallback
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource

) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)

    }

    override fun onSuccess(response: List<String>) {
//        val categories = mutableListOf<CategoryItem>()
//
//        for (category in response){
//            categories.add(CategoryItem(category))
//        }

        val start = 40 // h - matiz
        val end = 190 // h - matiz
        val diff = (end - start) / response.size

        val categories = response.mapIndexed { index, s ->
            val hsv = floatArrayOf(
                start + (diff * index).toFloat(),
                100.0f,
                100.0f
            )
            Category(s, Color.HSVToColor(hsv).toLong())
        }
        view.showCategories(categories)
    }

    override fun onComplete() {
        view.hideProgress()
    }


    override fun onError(message: String) {
        view.showFailure(message)
    }


}