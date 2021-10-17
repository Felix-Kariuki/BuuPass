package com.flexcode.buupass.models

import com.squareup.moshi.Json

data class UserListResponse(
    @field:Json(name = "page") val page: Int,
    @field:Json(name = "per_page") val per_page: Int,
    @field:Json(name = "id") val total: Int,
    @field:Json(name = "total_pages") val total_pages: Int,
    @field:Json(name = "data") val data: List<User>
)