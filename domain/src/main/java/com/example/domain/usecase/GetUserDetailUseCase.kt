package com.example.domain.usecase

import com.example.domain.UseCase
import com.example.domain.model.userDetail.UserDetail
import com.example.domain.repository.UserListRepository
import io.reactivex.Single
import javax.inject.Inject

class GetUserDetailUseCase @Inject constructor(
    private val userListRepository: UserListRepository
) : UseCase<GetUserDetailUseCase.Params, Single<UserDetail>>() {

    override fun createObservable(params: Params?): Single<UserDetail> {
        if (params == null) return Single.error(Exception("params = null"))
        return userListRepository.getDetailUser(
            params.userId,
            params.page,
            params.pageSize,
            params.site
        )
    }

    class Params(val userId: Int, val page: Int, val pageSize: Int, val site: String)
}