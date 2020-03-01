package com.example.data.remote.response

import com.example.data.remote.model.userDetail.UserDetailApi
import com.example.data.remote.model.userList.UserApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserListService {

    @GET("2.2/users")
    fun getUserList(
        @Query("page") page: Int,
        @Query("pagesize") pageSize: Int,
        @Query("site") pageSite: String
    ): Single<UserApi>

    @GET("2.2/users/{ids}/reputation-history")
    fun getUserDetail(
        @Path("ids") userId: Int,
        @Query("page") page: Int,
        @Query("pagesize") pageSize: Int,
        @Query("site") pageSite: String
    ): Single<UserDetailApi>
}