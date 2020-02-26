package com.example.base.adapter

import android.content.Context
import android.view.LayoutInflater
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<I : DisplayableItem, VH : RecyclerView.ViewHolder>(
    protected var context: Context?,
    diffCallback: DiffUtil.ItemCallback<I> = GeneralDiffCallback()
) : ListAdapter<I, VH>(diffCallback), LifecycleObserver {

    protected val inflater: LayoutInflater = LayoutInflater.from(this.context)

    override fun getItemViewType(position: Int): Int {
        return getItem(position).itemType
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected open fun onDestroy() {
        this.context = null
    }
}