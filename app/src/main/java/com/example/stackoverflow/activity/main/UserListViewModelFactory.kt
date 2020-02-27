package com.example.stackoverflow.activity.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetUserListUseCase
import javax.inject.Inject

class UserListViewModelFactory @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserListViewModel(getUserListUseCase) as T
    }
}