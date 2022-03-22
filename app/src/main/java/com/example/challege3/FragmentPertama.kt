package com.example.challege3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.challege3.databinding.FragmentPertamaBinding


class FragmentPertama : Fragment() {
    private  var _binding: FragmentPertamaBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPertamaBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnScreenone.setOnClickListener {
            //untuk menyambungkan fragmen 1 ke 2
            it.findNavController().navigate(R.id.action_fragmenPertama2_to_fragmentKedua)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}