package com.example.data.remote.response

import com.example.data.remote.model.UserApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserListService {

    @GET("2.2/users")
    fun getUserList(
        @Query("page") page: Int,
        @Query("pagesize") pageSize: Int
    ): Single<UserApi>
}