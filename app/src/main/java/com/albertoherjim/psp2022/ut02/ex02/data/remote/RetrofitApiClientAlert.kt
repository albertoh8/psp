package com.albertoherjim.psp2022.ut02.ex02.data.remote

import com.albertoherjim.psp2022.ut02.ex02.data.remote.models.AlertApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClientAlert {

    private val urlEndPoint = "https://plagricola.sitehub.es/api/public/alerts"
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

    fun getAlerts (): List<AlertApiModel>? {
        val callAlerts = apiEndPoints.getAlerts()//Llamada
        val response = callAlerts.execute() //Ejecución de la llamada
        return if (response.isSuccessful){
            val users= response.body()
            users ?: emptyList()
        } else{
            emptyList()
        }
    }
    fun getAlert(alertId:Int): AlertApiModel? {
        val userCall = apiEndPoints.getAlert(alertId)
        val response = userCall.execute()
        return if (response.isSuccessful){
            response.body()
        } else{
            null
        }

    }
}