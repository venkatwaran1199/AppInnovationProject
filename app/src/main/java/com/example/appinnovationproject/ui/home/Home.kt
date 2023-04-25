package com.example.appinnovationproject.ui.home

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.appinnovationproject.R
import com.example.appinnovationproject.databinding.FragmentHomeBinding
import com.example.appinnovationproject.models.data.Localdata
import com.example.appinnovationproject.viewmodel.LocalViewodel


class Home : Fragment() {


    private val Localviewmodel: LocalViewodel by viewModels()
        private var Hbinding:FragmentHomeBinding? = null
        private val binding get() = Hbinding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        Hbinding =  FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnsave.setOnClickListener {
            savetolocaldatabase()
        }
        return binding.root
    }

    private fun savetolocaldatabase() {
        val name = binding.edtname.text.toString()
        val age = binding.edtage.text.toString()
        val gender = binding.edtgender.text.toString()
        val langugaes = binding.edtlanguages.text.toString()
       val validation = Validateuser(name,age,gender,langugaes)
        if(validation){
            val data1 = Localdata(0,name,age,gender,langugaes)
            Toast.makeText(requireContext(),"Success$data1",Toast.LENGTH_SHORT).show()
            Localviewmodel.insertdata(data1)
            findNavController().navigate(R.id.action_home2_to_local)
        }else{
            Toast.makeText(requireContext(),"Failure",Toast.LENGTH_SHORT).show()
        }
    }

    private fun Validateuser(name: String, age: String, gender: String, langugaes: String): Boolean {
        return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(age) || TextUtils.isEmpty(gender)  || TextUtils.isEmpty(langugaes))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Hbinding = null
    }

}