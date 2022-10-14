package com.albertoherjim.psp2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.albertoherjim.psp2022.ut02.ex02.data.remote.RetrofitApiClientAlert

class MainActivity : AppCompatActivity() {

    val apiClient = RetrofitApiClientAlert()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread{
            val users = apiClient.getAlerts()
            Log.d("@dev", "Usuarios: $users")

        }.start()

        Thread{
            val user = apiClient.getAlert(10)
            Log.d("@dev", "Usuario: $user")

        }.start()

    }
}