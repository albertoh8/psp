package com.albertoherjim.psp2022.ut02.data.remote

import com.albertoherjim.psp2022.ut02.data.remote.models.UserApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClient {

    private val urlEndPoint = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoints: ApiEndPoints

    init {
        apiEndPoints = buildApiEndPoints()
    }

    private fun buildClient(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    private fun buildApiEndPoints(): ApiEndPoints{
        return buildClient().create(ApiEndPoints::class.java)
    }

    fun getUsers (): List<UserApiModel> {
        val callUsers = apiEndPoints.getUsers()//Llamada
        val response = callUsers.execute() //Ejecución de la llamada
        return if (response.isSuccessful){
            val users= response.body()
            users ?: emptyList()
        } else{
            emptyList()
        }
    }
}