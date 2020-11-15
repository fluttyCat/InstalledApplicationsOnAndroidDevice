package com.parisaghader.installedapplications.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.parisaghader.installedapplications.InstalledAppItem
import com.parisaghader.installedapplications.R
import com.parisaghader.installedapplications.adapters.AppListAdapter
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_app_list.*
import java.util.*

class AppListFragment : Fragment(R.layout.fragment_app_list) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val exampleList = generateDummyList(40)

        val adapter = AppListAdapter(exampleList)

        rvAppList.layoutManager = GridLayoutManager(requireContext(),3)
        rvAppList.adapter = adapter


        adapter.setOnItemClickListener {
            Toasty.success(requireContext(), "hello", Toast.LENGTH_SHORT, true).show()
        }

    }


    private fun generateDummyList(size: Int): List<InstalledAppItem> {

        val list = ArrayList<InstalledAppItem>()

        for (i in 0 until size) {

            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_audiotrack
                else -> R.drawable.ic_sun
            }
            val item = InstalledAppItem(drawable, "appName $i")
            list += item
        }
        return list
    }

}