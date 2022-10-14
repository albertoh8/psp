package com.albertoherjim.psp2022.ut02.ex03.data.remote

import com.albertoherjim.psp2022.ut02.ex02.data.remote.models.AlertApiModel
import com.albertoherjim.psp2022.ut02.ex03.data.remote.models.UserApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClientUser {
    private val urlEndPoint = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoints: ApiEndPoints

    init {
        apiEndPoints = buildApiEndPoints()
    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    private fun buildApiEndPoints(): ApiEndPoints {
        return buildClient().create(ApiEndPoints::class.java)
    }

    fun getUsers (): List<UserApiModel> {
        val callAlerts = apiEndPoints.getUsers()//Llamada
        val response = callAlerts.execute() //Ejecución de la llamada
        return if (response.isSuccessful){
            val users= response.body()
            users ?: emptyList()
        } else{
            emptyList()
        }
    }
    fun getUser(alertId:Int): UserApiModel? {
        val userCall = apiEndPoints.getUser(alertId)
        val response = userCall.execute()
        return if (response.isSuccessful){
            response.body()
        } else{
            null
        }

    }
}