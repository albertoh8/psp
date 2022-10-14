package com.albertoherjim.psp2022.ut02.ex02.data.remote.models

import com.albertoherjim.psp2022.ut02.ex03.data.remote.models.UserApiModel

data class Response( val statusCode: String, val data: List<UserApiModel>)