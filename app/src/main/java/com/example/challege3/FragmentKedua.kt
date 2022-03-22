package com.example.challege3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.challege3.databinding.FragmentKeduaBinding



class FragmentKedua : Fragment() {
    private var _binding: FragmentKeduaBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentKeduaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnTwo.setOnClickListener {
            val edittext = FragmentKeduaDirections.actionFragmentKeduaToFragmentTiga(binding.editTwo.text.toString())
            it.findNavController().navigate(edittext)

        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }




}

