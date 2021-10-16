package com.flexcode.buupass.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.flexcode.buupass.*
import com.flexcode.buupass.api.ApiClient
import com.flexcode.buupass.databinding.ActivityMainBinding
import com.flexcode.buupass.models.UserResponse
import com.flexcode.buupass.ui.fragments.HomeFragment
import com.flexcode.buupass.ui.fragments.ProfileFragment
import com.flexcode.buupass.ui.fragments.SearchFragment
import com.flexcode.buupass.ui.fragments.SettingsFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        //retrieving user data
        val userDataList = ApiClient.getUserService().getUserDetails()

        userDataList!!.enqueue(object : Callback<List<UserResponse?>?> {
            override fun onResponse(
                call: Call<List<UserResponse?>?>,
                response: Response<List<UserResponse?>?>
            ) {
                if (response.isSuccessful) {
                    Log.e("success", response.body().toString())
                }            }


            override fun onFailure(call: Call<List<UserResponse?>?>, t: Throwable) {
                Log.e("success", t.localizedMessage)
            }
        })

        val chip = findViewById<ChipNavigationBar>(R.id.chipNavigation)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.rv, HomeFragment()).commit()
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