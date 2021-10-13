package com.flexcode.buupass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flexcode.buupass.databinding.ActivityAvailableCarsBinding

class AvailableCarsActivity : AppCompatActivity() {

    lateinit var binding: ActivityAvailableCarsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAvailableCarsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.ivBack.setOnClickListener {
            val intent = Intent(this@AvailableCarsActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}