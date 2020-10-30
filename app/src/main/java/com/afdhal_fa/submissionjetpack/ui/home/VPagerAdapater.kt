package com.afdhal_fa.submissionjetpack.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.afdhal_fa.submissionjetpack.utils.Constants
import com.afdhal_fa.submissionjetpack.utils.VPager


class VPagerAdapater(private val fragment: List<VPager>, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var dataVPager1: String? = null
    var dataVPager2: String? = null

    override fun getItem(position: Int): Fragment {
        val mBundle = Bundle()
        mBundle.putString(Constants.VPAGER_DATA1, getData1())
        mBundle.putString(Constants.VPAGER_DATA2, getData2())

        fragment[position].fragment.arguments = mBundle

        return fragment[position].fragment
    }

    override fun getPageTitle(position: Int): CharSequence? = fragment[position].title

    override fun getCount(): Int = fragment.size

    fun setData(data: String) {
        dataVPager1 = data
    }

    fun setData(data1: String, data2: String) {
        dataVPager1 = data1
        dataVPager2 = data2
    }

    fun getData1(): String? = dataVPager1

    fun getData2(): String? = dataVPager2

}