package com.example.stackoverflow.activity.detail.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.base.adapter.BaseListAdapter
import com.example.base.adapter.DisplayableItem
import com.example.base.di.ActivityContext
import com.example.stackoverflow.R
import javax.inject.Inject

class UserDetailAdapter @Inject constructor(@ActivityContext context: Context) :
    BaseListAdapter<DisplayableItem, RecyclerView.ViewHolder>(context) {

    companion object {
        const val ITEM_USER_DETAIL = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_USER_DETAIL -> {
                val itemView = inflater.inflate(R.layout.item_user_detail, parent, false)
                UserDetailViewHolder(itemView)
            }
            else -> throw IllegalArgumentException("Do not support view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        return when (item.itemType) {
            ITEM_USER_DETAIL -> {
                val userDetail = item as UserDetailItem
                val userViewHolder = holder as UserDetailViewHolder
                userViewHolder.onBind(userDetail)
            }
            else -> throw IllegalArgumentException("Do not support view type: ${item.itemType}")
        }
    }

}