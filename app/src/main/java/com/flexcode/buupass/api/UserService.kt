package com.flexcode.buupass.api

import com.flexcode.buupass.models.LoginRequest
import com.flexcode.buupass.models.LoginResponse
import com.flexcode.buupass.models.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {

    @POST("/api/login")
    fun userLogin(@Body loginRequest: LoginRequest?): Call<LoginResponse?>?

    @GET("/api/users/2")
    fun getUserDetails(): Call<List<UserResponse?>?>?
}