package com.parisaghader.installedapplications.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.parisaghader.installedapplications.R
import com.parisaghader.installedapplications.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_view_pager.*

class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragments = arrayListOf<Fragment>()


        fragments.add(AppListFragment())
        setUpViewPagerAdapter(fragments)

        TabLayoutMediator(tabLayout, appListViewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"

        }.attach()

    }

    private fun setUpViewPagerAdapter(fragmentList: ArrayList<Fragment>) {
        val list2: ArrayList<Fragment> = arrayListOf()
        for (item in fragmentList) {

            list2.add(item)
        }
        appListViewPager.adapter = ViewPagerAdapter(
            list2,
            childFragmentManager,
            lifecycle
        )
//        appListViewPager.isUserInputEnabled = false
    }


}