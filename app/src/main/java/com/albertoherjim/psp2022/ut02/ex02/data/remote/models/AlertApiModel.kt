package com.albertoherjim.psp2022.ut02.ex02.data.remote.models

import com.albertoherjim.psp2022.ut02.ex02.data.remote.models.file

data class AlertApiModel (val id:Int, val alertId:Int,val title:String,val type:Int,   val date: String,val summary: String, val body:String, val source:String, val files: List<file>)