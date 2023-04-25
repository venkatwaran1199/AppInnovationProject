package com.example.appinnovationproject.ui.local

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appinnovationproject.databinding.FragmentLocalBinding
import com.example.appinnovationproject.models.data.Localdata
import com.example.appinnovationproject.viewmodel.LocalViewodel

class Local : Fragment() {

    private var Lbinding:FragmentLocalBinding? = null
    private val binding get() = Lbinding!!
    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter:LocalAdapter
    private val Localviewmodel:LocalViewodel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        Lbinding =  FragmentLocalBinding.inflate(inflater, container, false)
        initrecyclerviews()
        Localviewmodel.getalldata.observe(viewLifecycleOwner){
            adapter.setdata(it)
        }

        return binding.root
    }

    private fun initrecyclerviews() {
        adapter = LocalAdapter()
        recyclerView = binding.localrecycler
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Lbinding = null
    }
}