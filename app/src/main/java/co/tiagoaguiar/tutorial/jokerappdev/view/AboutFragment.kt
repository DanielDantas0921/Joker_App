package co.tiagoaguiar.tutorial.jokerappdev.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import co.tiagoaguiar.tutorial.jokerappdev.BuildConfig

import co.tiagoaguiar.tutorial.jokerappdev.R



class AboutFragment : Fragment(R.layout.fragment_about) {

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return  inflater.inflate(R.layout.fragment_about, container, false)
//
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.tv_version_about).text = getString(R.string.build_version, BuildConfig.VERSION_NAME)
    }
}