package com.afdhal_fa.submissionjetpack.ui.tv_show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.afdhal_fa.submissionjetpack.R
import com.afdhal_fa.submissionjetpack.ui.home.HomeAdapter
import com.afdhal_fa.submissionjetpack.utils.Constants
import com.afdhal_fa.submissionjetpack.viewmodel.ViewModelFactory
import com.dicoding.academies.vo.Status
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TVShowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModle = ViewModelProvider(this, factory)[TVShowVModel::class.java]

            val postion = arguments?.getString(Constants.VPAGER_DATA2) as String
            val tvShowAdapter = HomeAdapter()
            progress_bar.visibility = View.VISIBLE

            if (postion == "tv_show_favorite") {
                viewModle.getTVShowFavorite().observe(viewLifecycleOwner, {
                    progress_bar.visibility = View.GONE
                    tvShowAdapter.submitList(it)
                    tvShowAdapter.setPosition(postion)
                    tvShowAdapter.notifyDataSetChanged()
                })
            } else {
                viewModle.getTVShow().observe(viewLifecycleOwner, {
                    when(it.status) {
                        Status.LOADING -> progress_bar.visibility = View.VISIBLE

                        Status.SUCCESS -> {
                            progress_bar.visibility = View.GONE
                            tvShowAdapter.submitList(it.data)
                            tvShowAdapter.setPosition(postion)
                            tvShowAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            progress_bar.visibility = View.GONE
                            Toast.makeText(this.context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()

                        }
                    }

                })
            }

            with(recycleview_tv_show) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }
}