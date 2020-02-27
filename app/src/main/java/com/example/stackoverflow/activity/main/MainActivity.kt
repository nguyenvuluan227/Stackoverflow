package com.example.stackoverflow.activity.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stackoverflow.R
import com.example.stackoverflow.activity.main.adapter.UserListAdapter
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    @Inject
    lateinit var viewModel: UserListViewModel
    @Inject
    lateinit var adapter: UserListAdapter
    private lateinit var linearLayout: LinearLayoutManager

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        linearLayout = LinearLayoutManager(this).apply {
            this.isItemPrefetchEnabled = true
            this.initialPrefetchItemCount = 30
        }

        recyclerView.layoutManager = linearLayout
        recyclerView.adapter = adapter
        
        viewModel.state.observe(this, Observer {
            adapter.submitList(it.uiItems)
        })
        viewModel.getListUser(1, 30, "stackoverflow")

    }

}
