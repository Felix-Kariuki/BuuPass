package com.flexcode.buupass.api

import com.flexcode.buupass.models.LoginRequest
import com.flexcode.buupass.models.LoginResponse
import com.flexcode.buupass.models.UserListResponse
import com.flexcode.buupass.models.UserResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {

    @POST("/api/login")
    fun userLogin(@Body loginRequest: LoginRequest?): Call<LoginResponse?>?

    @GET("/api/users")
    suspend fun getUsers(): UserListResponse

    companion object {
        fun createUserApiService(): UserService =
            Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UserService::class.java)
    }
}