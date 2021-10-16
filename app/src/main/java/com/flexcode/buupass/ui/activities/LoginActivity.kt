package com.flexcode.buupass.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.flexcode.buupass.api.ApiClient
import com.flexcode.buupass.models.LoginRequest
import com.flexcode.buupass.models.LoginResponse
import com.flexcode.buupass.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var email: String
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        email = binding.etUserName.text.toString().trim()
        password = binding.etPassword.text.toString().trim()

        binding.btnLogin.setOnClickListener {

            login()

            /*val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()*/
        }
        binding.btnFire.setOnClickListener {
            val intent = Intent(this@LoginActivity, FireLoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun login() {
        val loginRequest = LoginRequest()
        loginRequest.setUsername(binding.etUserName.text.toString())
        loginRequest.setPassword(binding.etPassword.text.toString())
        val loginResponseCall = ApiClient.getUserService().userLogin(loginRequest)
        loginResponseCall?.enqueue(object : Callback<LoginResponse?> {
            override fun onResponse(
                call: Call<LoginResponse?>,
                response: Response<LoginResponse?>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        this@LoginActivity,
                        "Login Successful",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Login Failure",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                Toast.makeText(
                    this@LoginActivity,
                    "Error" + t.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}