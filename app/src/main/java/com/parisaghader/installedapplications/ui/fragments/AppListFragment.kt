package com.parisaghader.installedapplications.ui.fragments

import android.app.Dialog
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.parisaghader.installedapplications.R
import com.parisaghader.installedapplications.adapters.AppListAdapter
import com.parisaghader.installedapplications.models.InstalledAppItem
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_app_list.*
import java.util.*

class AppListFragment : Fragment(R.layout.fragment_app_list) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val exampleList = generateDummyList(40)*/

        setupRecyclerView()


    }

    private fun setupRecyclerView() {
        val installedAppList = getInstalledApps()
        val adapter = AppListAdapter(installedAppList)

        rvAppList.layoutManager = GridLayoutManager(requireContext(), 4)
        rvAppList.adapter = adapter


        adapter.setOnItemClickListener {}



//            Toasty.success(requireContext(), "hello", Toast.LENGTH_SHORT, true).show()
            /*  val dialogBuilder = AlertDialog.Builder(requireContext())

              val inflater: LayoutInflater = requireActivity().layoutInflater

              val dialogView: View = inflater.inflate(R.layout.custom_dialog, null)
              dialogBuilder.setView(dialogView)
              dialogBuilder.show()

  //            val alertDialog: AlertDialog = dialogBuilder.create()
  //            alertDialog.show()
  */


    }

    private fun getInstalledApps(): List<InstalledAppItem> {
        val packageManager: PackageManager = requireActivity().packageManager

        val list = ArrayList<InstalledAppItem>()

        val appInfo = packageManager.getInstalledPackages(0)

        for (i in 0 until appInfo.size) {
            val p = appInfo[i]

            val appName = p.applicationInfo.loadLabel(packageManager).toString()

            val icon = p.applicationInfo.loadIcon(packageManager)

            val item = InstalledAppItem(icon, appName)
            list += item

//             dialogIv.setImageDrawable(icon)
//             dialogTv.text = appName
        }
        return list
    }


    /*private fun generateDummyList(size: Int): List<InstalledAppItem> {

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
*/
}