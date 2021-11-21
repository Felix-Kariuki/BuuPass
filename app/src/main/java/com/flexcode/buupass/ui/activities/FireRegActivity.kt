package com.flexcode.buupass.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flexcode.buupass.R
import com.flexcode.buupass.databinding.ActivityFireRegBinding

class FireRegActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFireRegBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFireRegBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}