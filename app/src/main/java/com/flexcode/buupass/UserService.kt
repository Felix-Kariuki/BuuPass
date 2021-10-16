package com.flexcode.buupass

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {

    @POST("/api/login")
    fun userLogin(@Body loginRequest: LoginRequest?): Call<LoginResponse?>?



}