package com.example.stackoverflow.activity.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetUserDetailUseCase
import javax.inject.Inject

class UserDetailViewModelFactory @Inject constructor(
    private val userDetailUseCase: GetUserDetailUseCase
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserDetailViewModel(userDetailUseCase) as T
    }
}