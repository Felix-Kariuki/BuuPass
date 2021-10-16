package com.flexcode.buupass.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flexcode.buupass.databinding.FragmentHomeBinding
import com.flexcode.buupass.ui.activities.AvailableCarsActivity


class HomeFragment : Fragment() {

    private var binding : FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        val root: View = binding!!.root
        binding!!.cvAvailableCars.setOnClickListener {
            val intent = Intent(context, AvailableCarsActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}