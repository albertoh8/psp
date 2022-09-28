package com.albertoherjim.psp2022.ut01.ex01.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.albertoherjim.psp2022.R

class Ut01Ex01Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex01)
        val label: TextView = findViewById(R.id.label)
        label.text= getString(R.string.title)

        Thread{
            Thread.sleep(2000)
            runOnUiThread{
                label.text= "Cambiado!"
            }


            Log.d("@dev","Thread1")
        }.start()
    }
}