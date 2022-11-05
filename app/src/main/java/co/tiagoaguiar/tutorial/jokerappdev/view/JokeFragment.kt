package co.tiagoaguiar.tutorial.jokerappdev.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import co.tiagoaguiar.tutorial.jokerappdev.presentation.JokePresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class JokeFragment : Fragment(R.layout.fragment_joke) {

    private lateinit var progressBar: ProgressBar
    private lateinit var tv: TextView
    private lateinit var img: ImageView
    private lateinit var presenter: JokePresenter

    companion object {
        const val CATEGORY_KEY = "category"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = JokePresenter(this)
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return  inflater.inflate(R.layout.fragment_joke, container, false)
//
//    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryName = arguments?.getString(CATEGORY_KEY)!!
        activity?.findViewById<Toolbar>(R.id.toolbar)?.title = categoryName
        progressBar = view.findViewById(R.id.progress_bar_joke)
        tv = view.findViewById(R.id.txt_joke)
        img = view.findViewById(R.id.img_joke)
        view.findViewById<FloatingActionButton>(R.id.fab_joke).setOnClickListener{
            presenter.findBy(categoryName)
        }
        presenter.findBy(categoryName)
    }

    fun showJoke(joke: Joke) {
        tv.text = joke.text
        Picasso.get().load(joke.iconUrl).into(img)
    }

    fun showProgress(){
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgress(){
        progressBar.visibility = View.GONE
    }
    fun showFailure(message: String) {

        Toast.makeText(requireContext(),message, Toast.LENGTH_LONG).show()
    }

}