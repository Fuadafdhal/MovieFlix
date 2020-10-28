package com.afdhal_fa.submissionjetpack.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.afdhal_fa.submissionjetpack.R
import com.afdhal_fa.submissionjetpack.ui.home.HomeAdapter
import com.afdhal_fa.submissionjetpack.utils.Constants
import com.afdhal_fa.submissionjetpack.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {


            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModle = ViewModelProvider(this, factory)[MovieVModel::class.java]

            val postion = arguments?.getString(Constants.VPAGER_DATA1) as String
            val movieAdapter = HomeAdapter()

            progress_bar.visibility = View.VISIBLE
            viewModle.getMovies().observe(viewLifecycleOwner, {
                progress_bar.visibility = View.GONE
                movieAdapter.setMovie(it)
                movieAdapter.setPosition(postion)
                movieAdapter.notifyDataSetChanged()
            })

            with(recycleview) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
}