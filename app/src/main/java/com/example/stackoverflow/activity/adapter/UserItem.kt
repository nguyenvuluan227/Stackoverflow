package com.example.stackoverflow.activity.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.base.adapter.DisplayableItem
import com.example.domain.model.User

class UserItem(user: User) : DisplayableItem {
    override val itemType: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun getKey(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun onBind() {

    }
}