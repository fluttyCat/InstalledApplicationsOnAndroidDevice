package com.parisaghader.installedapplications.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.parisaghader.installedapplications.InstalledAppItem
import com.parisaghader.installedapplications.R
import kotlinx.android.synthetic.main.installed_app_item.view.*

class AppListAdapter(var list: List<InstalledAppItem>) :

    RecyclerView.Adapter<AppListAdapter.AppListViewHolder>() {

    inner class AppListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    /*  private val differCallback = object : DiffUtil.ItemCallback<InstalledAppItem>() {
          override fun areItemsTheSame(
              oldItem: InstalledAppItem,
              newItem: InstalledAppItem
          ): Boolean {
              return oldItem.appName == newItem.appName
          }

          override fun areContentsTheSame(
              oldItem: InstalledAppItem,
              newItem: InstalledAppItem
          ): Boolean {
              return oldItem == newItem
          }
      }


      private val differ = AsyncListDiffer(this, differCallback)*/

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
                    Toast.makeText(context,"hello",Toast.LENGTH_SHORT).show()
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
}