package com.albertoherjim.psp2022.ut02.ex03.data.remote

import com.albertoherjim.psp2022.ut02.ex03.data.remote.models.UserApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface  ApiEndPoints {

    @GET("users")
    fun getUsers(): Call<List<UserApiModel>>

    @GET("users/{userId}")
    fun getUser(@Path("userId") id: Int): Call<UserApiModel>

}