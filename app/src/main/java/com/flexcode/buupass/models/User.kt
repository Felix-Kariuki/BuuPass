package com.flexcode.buupass.models

import com.squareup.moshi.Json

data class User(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "email") val email: String,
    @field:Json(name = "first_name") val first_name: String,
    @field:Json(name = "last_name") val last_name: String,
    @field:Json(name = "avatar") val avatar: String
)
