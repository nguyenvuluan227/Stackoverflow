package com.example.stackoverflow.activity.main

import android.util.Log
import com.example.base.BaseViewModel
import com.example.base.Event
import com.example.base.adapter.DisplayableItem
import com.example.domain.model.Item
import com.example.domain.usecase.GetUserListUseCase
import com.example.stackoverflow.activity.main.adapter.UserItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserListViewModel(private val getUserListUseCase: GetUserListUseCase) :
    BaseViewModel<UserListState>() {
    override fun initState(): UserListState =
        UserListState()

    fun getListUser(page: Int, pageSize: Int, pageSite: String) {
        getUserListUseCase.createObservable(GetUserListUseCase.Params(page, pageSize, pageSite))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.d("getListUser", "HAS DATA")
                    setState {
                        copy(
                            error = Event(false),
                            uiItems = convertDataToUI(it.items!!)
                        )
                    }
                },
                {
                    it.printStackTrace()
                    Log.d("getListUser", "NO DATA")
                    setState {
                        copy(error = Event(true))
                    }
                }
            ).addToDisposables()
    }

    private fun convertDataToUI(userList: List<Item>): List<DisplayableItem> {
        return userList.map {
            UserItem(
                it
            )
        }
    }

}

data class UserListState(
    val error: Event<Boolean>? = null,
    val uiItems: List<DisplayableItem> = listOf()
)