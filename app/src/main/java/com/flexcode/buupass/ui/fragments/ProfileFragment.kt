package com.flexcode.buupass.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.flexcode.buupass.api.UserService
import com.flexcode.buupass.databinding.FragmentProfileBinding
import java.io.IOException
import java.lang.StringBuilder


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater,container,false)

        val view = binding.root
        lifecycleScope.launchWhenCreated {
            try {
                val users = UserService
                    .createUserApiService()
                    .getUsers()
                val tvNames = binding.tvNames
                val sb = StringBuilder()
                for (user in users.data) {
                    /*sb.append(user.first_name)
                    sb.append("\n")*/
                    if (user.first_name == "Eve"){
                        sb.append(user.first_name)
                        sb.append("\n")
                        sb.append(user.last_name)
                        sb.append("\n")
                        sb.append(user.id)
                        sb.append("\n")
                        sb.append(user.avatar)
                        sb.append("\n")
                        sb.append(user.email)
                        sb.append("\n")
                    }
                }
                tvNames.text = sb.toString()
            }catch (e: IOException){
                Log.e("users","IO Exception")
            }
        }
        // Inflate the layout for this fragment
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}