package co.tiagoaguiar.tutorial.jokerappdev.view

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import co.tiagoaguiar.tutorial.jokerappdev.presentation.JokeDayPresenter
import co.tiagoaguiar.tutorial.jokerappdev.presentation.JokePresenter
import com.squareup.picasso.Picasso

class JokeDayFragment : Fragment() {

    private  lateinit var tv: TextView
    private lateinit var progressBar: ProgressBar
   private lateinit var img : ImageView
    private lateinit var presenter: JokeDayPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = JokeDayPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_joke_day, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         img = view.findViewById(R.id.img_joke_day)
        tv = view.findViewById(R.id.txt_joke_day)
        progressBar = view.findViewById(R.id.progress_bar_joke_day)
        presenter.findRandom()


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