package com.example.domain.usecase

import com.example.domain.UseCase
import com.example.domain.model.User
import com.example.domain.repository.UserListRepository
import io.reactivex.Single
import java.lang.Exception
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val userListRepository: UserListRepository
) : UseCase<GetUserListUseCase.Params, Single<User>>() {


    override fun createObservable(params: Params?): Single<User> {
        if (params == null) return Single.error(Exception("params = null"))
        return userListRepository.getListUser(params.page, params.pageSize, params.pageSite)
    }

    class Params(val page: Int, val pageSize: Int, val pageSite: String)
}