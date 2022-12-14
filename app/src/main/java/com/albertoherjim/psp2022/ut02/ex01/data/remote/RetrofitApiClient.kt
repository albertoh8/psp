package com.albertoherjim.psp2022.ut02.ex01.data.remote

import com.albertoherjim.psp2022.ut02.ex02.data.remote.ApiEndPointsAlert
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClient {

    private val urlEndPoint = "https://jsonplaceholder.typicode.com/"

    private var apiEndPoints: ApiEndPointsAlert

    init {
        apiEndPoints = buildApiEndPoints()
    }

    private fun buildClient(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    private fun buildApiEndPoints(): ApiEndPointsAlert {
        return buildClient().create(ApiEndPointsAlert::class.java)
    }

    /**fun getUsers (): List<UserApiModel> {
        val callUsers = apiEndPoints.getUsers()//Llamada
        val response = callUsers.execute() //Ejecución de la llamada
        return if (response.isSuccessful){
            val users= response.body()
            users ?: emptyList()
        } else{
            emptyList()
        }
    }
    fun getUser(userId:Int): UserApiModel? {
        val userCall = apiEndPoints.getUser(userId)
        val response = userCall.execute()
        return if (response.isSuccessful){
            response.body()
        } else{
            null
        }

    }**/
}