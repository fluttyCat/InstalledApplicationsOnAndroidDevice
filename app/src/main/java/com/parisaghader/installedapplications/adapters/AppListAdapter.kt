package com.parisaghader.installedapplications.adapters

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.RecyclerView
import com.parisaghader.installedapplications.R
import com.parisaghader.installedapplications.models.InstalledAppItem
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.installed_app_item.view.*

class AppListAdapter(var list: List<InstalledAppItem>) :

    RecyclerView.Adapter<AppListAdapter.AppListViewHolder>() {


    inner class AppListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppListViewHolder {
        return AppListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.installed_app_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AppListViewHolder, position: Int) {

//        val currentItem = differ.currentList[position]


        holder.itemView.apply {
            circleImageView.setImageDrawable(list[position].image)
            appName.text = list[position].appName


            setOnClickListener {
                onItemClickListener.let {
                    showDialog(context, position)
                }
            }
        }
    }

    override fun getItemCount(): Int {

        return list.size
    }


    private var onItemClickListener: ((InstalledAppItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (InstalledAppItem) -> Unit) {
        onItemClickListener = listener
    }

    private fun showDialog(context: Context, position: Int) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.custom_dialog)

        dialog.dialogIv.setImageDrawable(list[position].image)
        dialog.dialogTv.text = list[position].appName
        dialog.closeIv.setOnClickListener { dialog.dismiss() }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }
}