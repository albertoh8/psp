package com.albertoherjim.psp2022.ut02.ex02.data.remote

import com.albertoherjim.psp2022.ut02.ex02.data.remote.models.AlertApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPointsAlert {

    @GET("data")
    fun getAlerts(): Call<List<AlertApiModel>>

    @GET("data/{alertId}")
    fun getAlert(@Path("alertId") alertId: Int): Call<AlertApiModel>

}