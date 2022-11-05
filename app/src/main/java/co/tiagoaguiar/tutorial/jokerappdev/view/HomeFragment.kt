package co.tiagoaguiar.tutorial.jokerappdev.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.data.CategoryRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.presentation.HomePresenter
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val adapter = GroupieAdapter()
    private lateinit var progressBar: ProgressBar

    private lateinit var presenter: HomePresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       val dataSource = CategoryRemoteDataSource()
        presenter = HomePresenter(this,dataSource)

    }


//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//       return  inflater.inflate(R.layout.fragment_home, container, false)
//
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById(R.id.progress_bar)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_main)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        if(adapter.itemCount == 0){

            presenter.findAllCategories()
        }


        recyclerView.adapter = adapter

        adapter.setOnItemClickListener { item, view ->
            val bundle  = Bundle()
            val categoryName = (item as CategoryItem).category.nome
            bundle.putString(JokeFragment.CATEGORY_KEY,categoryName)
            findNavController().navigate(R.id.action_nav_home_to_nav_joke, bundle)
        }



    }
    fun showCategories(response: List<Category>){
        val categories = response.map { CategoryItem(it) }
        adapter.addAll(categories)
        adapter.notifyDataSetChanged()

    }

    fun showProgress() {
        progressBar.visibility = View.VISIBLE

    }

    fun hideProgress() {

        progressBar.visibility = View.GONE
    }

    fun showFailure(message: String) {

        Toast.makeText(requireContext(),message,Toast.LENGTH_LONG).show()
    }


}