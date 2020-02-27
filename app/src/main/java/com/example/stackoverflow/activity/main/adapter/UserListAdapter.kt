package com.example.stackoverflow.activity.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.base.adapter.BaseListAdapter
import com.example.base.adapter.DisplayableItem
import com.example.base.di.ActivityContext
import com.example.stackoverflow.R
import javax.inject.Inject

class UserListAdapter @Inject constructor(@ActivityContext context: Context) :
    BaseListAdapter<DisplayableItem, RecyclerView.ViewHolder>(context) {

    companion object {
        const val ITEM_USER = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_USER -> {
                val itemView = inflater.inflate(R.layout.item_user_list, parent, false)
                UserViewHolder(itemView)
            }
            else -> throw IllegalArgumentException("Do not support view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        return when (item.itemType) {
            ITEM_USER -> {
                val userItem = item as UserItem
                val userViewHolder = holder as UserViewHolder
                userViewHolder.onBind(userItem)
            }
            else -> throw IllegalArgumentException("Do not support view type: ${item.itemType}")
        }
    }

}