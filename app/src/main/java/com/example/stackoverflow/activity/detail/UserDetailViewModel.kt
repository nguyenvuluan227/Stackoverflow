package com.example.stackoverflow.activity.detail

import android.util.Log
import com.example.base.BaseViewModel
import com.example.base.Event
import com.example.base.adapter.DisplayableItem
import com.example.domain.model.userDetail.UserItems
import com.example.domain.usecase.GetUserDetailUseCase
import com.example.stackoverflow.activity.detail.adapter.UserDetailItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserDetailViewModel(private val getUserDetailUseCase: GetUserDetailUseCase) :
    BaseViewModel<UserDetailState>() {
    override fun initState(): UserDetailState = UserDetailState()

    fun getUserDetail(userId: Int, page: Int, pageSize: Int, site: String) {
        setState {
            copy(
                isLoading = Event(true),
                isLoadingSuccess = Event(false)
            )
        }
        getUserDetailUseCase.createObservable(
            GetUserDetailUseCase.Params(
                userId,
                page,
                pageSize,
                site
            )
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    setState {
                        Log.d("UserDetailViewModel", "HAS DATA")
                        copy(
                            error = Event(false),
                            uiItems = convertDataToUI(it.userItems),
                            isLoading = Event(false),
                            isLoadingSuccess = Event(true)
                        )
                    }
                },
                {
                    it.printStackTrace()
                    Log.d("UserDetailViewModel", "NO DATA")
                    setState {
                        copy(error = Event(true))
                    }
                }
            )
            .addToDisposables()
    }

    private fun convertDataToUI(user: List<UserItems>): List<DisplayableItem> {
        return user.map { UserDetailItem(it) }
    }

}


data class UserDetailState(
    val error: Event<Boolean>? = null,
    val uiItems: List<DisplayableItem> = listOf(),
    val isLoading: Event<Boolean>? = null,
    val isLoadingSuccess: Event<Boolean>? = null
)