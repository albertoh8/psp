package com.albertoherjim.psp2022.ut02.ex03.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.albertoherjim.psp2022.R
import com.albertoherjim.psp2022.ut02.ex03.data.remote.RetrofitApiClientUser

class ut02_ex03_Activity : AppCompatActivity() {

    val apiClient = RetrofitApiClientUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut02_ex03)

        Thread{
            val users = apiClient.getUsers()
            Log.d("@dev", "Usuarios: $users")

        }.start()

        Thread{
            val user = apiClient.getUser(10)
            Log.d("@dev", "Usuario: $user")

        }.start()

    }
}