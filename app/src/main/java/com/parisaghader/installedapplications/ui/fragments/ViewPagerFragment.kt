package com.parisaghader.installedapplications.ui.fragments

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.parisaghader.installedapplications.R
import com.parisaghader.installedapplications.adapters.ViewPagerAdapter
import com.parisaghader.installedapplications.models.InstalledAppItem
import kotlinx.android.synthetic.main.fragment_view_pager.*

class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragments = arrayListOf<Fragment>()
        var counter = 0
        var startIndex = 0
        var endIndex = 0
        for (i in getInstalledApps().indices) {
            if (counter == 20) {
                endIndex = i
                fragments.add(AppListFragment(startIndex, endIndex))
                counter = -1
                startIndex = i + 1
            }
            counter += 1
        }

        setUpViewPagerAdapter(fragments)

        TabLayoutMediator(tabLayout, appListViewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()

    }

    private fun setUpViewPagerAdapter(fragmentList: ArrayList<Fragment>) {
        appListViewPager.adapter = ViewPagerAdapter(
            fragmentList,
            childFragmentManager,
            lifecycle
        )
    }

    private fun getInstalledApps(): List<InstalledAppItem> {
        val packageManager: PackageManager = requireActivity().packageManager

        val list = java.util.ArrayList<InstalledAppItem>()

        val appInfo = packageManager.getInstalledPackages(0)

        for (i in 0 until appInfo.size) {
            val p = appInfo[i]

            val appName = p.applicationInfo.loadLabel(packageManager).toString()

            val icon = p.applicationInfo.loadIcon(packageManager)

            val item = InstalledAppItem(icon, appName)
            list += item

        }
        AppListFragment.InstalledApps = list
        return list
    }


}