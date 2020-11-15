package com.parisaghader.installedapplications.ui.fragments

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.parisaghader.installedapplications.R
import com.parisaghader.installedapplications.adapters.AppListAdapter
import com.parisaghader.installedapplications.models.InstalledAppItem
import kotlinx.android.synthetic.main.fragment_app_list.*
import java.util.*

class AppListFragment(
    private val startIndex: Int,
    private val endIndex: Int,
) : Fragment(R.layout.fragment_app_list) {

    companion object{
        var InstalledApps = arrayListOf<InstalledAppItem>()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val installedAppList = arrayListOf<InstalledAppItem>()
        InstalledApps.forEachIndexed { index, installedAppItem ->
            if (index in startIndex until endIndex) {
                installedAppList.add(installedAppItem)
            }
        }

        val adapter = AppListAdapter(installedAppList)
        rvAppList.layoutManager = GridLayoutManager(requireContext(), 4)
        rvAppList.adapter = adapter
        adapter.setOnItemClickListener {}
    }

}