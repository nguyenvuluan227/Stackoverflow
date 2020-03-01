package com.example.stackoverflow.activity.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.base.onEvent
import com.example.stackoverflow.R
import com.example.stackoverflow.activity.detail.DetailActivity
import com.example.stackoverflow.activity.main.adapter.UserListAdapter
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    companion object {
        const val USER_ID = "userId"
    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    @Inject
    lateinit var viewModel: UserListViewModel
    @Inject
    lateinit var adapter: UserListAdapter

    private lateinit var linearLayout: LinearLayoutManager
    private var page: Int = 1
    private var pageSize: Int = 30


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

        rvMain.layoutManager = linearLayout
        rvMain.adapter = adapter.apply { onItemClicked = { onSubmit(it) } }

        viewModel.state.observe(this, Observer {
            onEvent(it.isLoading) {
                if (this) {
                    pbLoading.visibility = View.VISIBLE
                    clMain.alpha = 0.5F
                } else {
                    pbLoading.visibility = View.GONE
                    clMain.alpha = 1F
                }


            }

            onEvent(it.isLoadingSuccess) {
                if (this) {
                    adapter.submitList(it.uiItems)
                }
            }

        })
        viewModel.getListUser(page, pageSize, getString(R.string.page_site))
    }

    private fun onSubmit(userId: Int) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(USER_ID, userId)
        startActivity(intent)
    }
}
