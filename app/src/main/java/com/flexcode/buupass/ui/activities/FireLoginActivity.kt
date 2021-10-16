package com.flexcode.buupass.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.flexcode.buupass.databinding.ActivityFireLoginBinding
import com.google.firebase.auth.FirebaseAuth

class FireLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFireLoginBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFireLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        mAuth = FirebaseAuth.getInstance()

        binding.btnLoginFire.setOnClickListener {
            loginUser()
        }
        //Login the user if already has an account
        /*if (mAuth.currentUser != null){
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }*/
    }

    private fun loginUser() {
        val email: String = binding.etUserName.text.toString().trim()
        val password: String = binding.etPassword.text.toString().trim()

        when {

            email.isEmpty() -> {
                Toast.makeText(this,"Please enter email",
                    Toast.LENGTH_SHORT).show()
            }
            password.isEmpty() -> {
                Toast.makeText(this,"Please enter password",
                    Toast.LENGTH_SHORT).show()
            }
            else ->{
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task->
                    if (task.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                        intent.addFlags(
                            Intent.FLAG_ACTIVITY_CLEAR_TASK or
                                Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                        Toast.makeText(this, "Login Successful!",
                            Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(this,"Error:"
                                + task.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}