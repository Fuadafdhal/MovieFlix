package com.afdhal_fa.submissionjetpack.ui.tv_show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.afdhal_fa.submissionjetpack.R
import com.afdhal_fa.submissionjetpack.ui.home.HomeAdapter
import com.afdhal_fa.submissionjetpack.ui.home.HomeVModel
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlin.math.log

class TVShowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val viewModle = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[HomeVModel::class.java]

            val mTVShows = viewModle.getTVShow(requireContext())
            val postion = arguments?.getString("VPAGER_DATA2") as String
            println(postion)


            val tvShowAdapter = HomeAdapter()
            tvShowAdapter.setMovie(mTVShows)
            tvShowAdapter.setPosition(postion)

            with(recycleview) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }
}