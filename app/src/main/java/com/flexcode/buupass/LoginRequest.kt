package com.flexcode.buupass

class LoginRequest {
    private var email: String? = null
    private var password: String? = null

    fun getUsername(): String? {
        return email
    }

    fun setUsername(username: String?) {
        this.email = username
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String?) {
        this.password = password
    }
}