package com.flexcode.buupass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.flexcode.buupass.databinding.ActivityMainBinding
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        val chip = findViewById<ChipNavigationBar>(R.id.chipNavigation)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.rv,HomeFragment()).commit()
            chip.setItemSelected(R.id.home)
        }
        chip.setOnItemSelectedListener { id ->
            when(id){
                R.id.home -> fragment = HomeFragment()

                R.id.search -> fragment = SearchFragment()

                R.id.account -> fragment = ProfileFragment()

                R.id.settings -> fragment = SettingsFragment()

            }

            fragment!!.let {
                supportFragmentManager.beginTransaction().replace(R.id.rv,fragment!!).commit()
            }
        }
    }
}