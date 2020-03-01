package com.example.stackoverflow.activity.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stackoverflow.R
import com.example.stackoverflow.activity.detail.adapter.UserDetailAdapter
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), HasAndroidInjector {

    companion object {
        const val USER_ID = "userId"
    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    @Inject
    lateinit var viewModel: UserDetailViewModel
    @Inject
    lateinit var adapter: UserDetailAdapter

    private lateinit var linearLayout: LinearLayoutManager

    private var userId: Int? = null
    private var page: Int = 1
    private var pageSize: Int = 30

    override fun androidInjector(): AndroidInjector<Any> = androidInjector


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getData()
        initView()
    }

    private fun getData() {
        userId = intent.getIntExtra(USER_ID, 0)
    }

    private fun initView() {
        linearLayout = LinearLayoutManager(this).apply {
            this.isItemPrefetchEnabled = true
            this.initialPrefetchItemCount = 30
        }

        rvDetail.layoutManager = linearLayout
        rvDetail.adapter = adapter


        viewModel.state.observe(this, Observer {
            adapter.submitList(it.uiItems)
        })
        viewModel.getUserDetail(userId!!, page, pageSize, getString(R.string.page_site))

    }

}
