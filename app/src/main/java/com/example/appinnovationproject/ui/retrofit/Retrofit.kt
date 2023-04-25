package com.example.appinnovationproject.ui.retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appinnovationproject.databinding.FragmentRetrofitBinding

class Retrofit : Fragment() {

    private var Rbinding:FragmentRetrofitBinding? = null
    private val binding get() = Rbinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        Rbinding =  FragmentRetrofitBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Rbinding = null
    }
}