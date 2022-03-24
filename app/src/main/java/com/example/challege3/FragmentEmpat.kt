package com.example.challege3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.challege3.databinding.FragmentEmpatBinding

class FragmentEmpat : Fragment() {
    private lateinit var binding: FragmentEmpatBinding
    //untuk menerima data nama dari fragmen 3 menggunakan argumen
    val args : FragmentEmpatArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmpatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //menerima nama
        val name = args.nama
        binding.btnFour.setOnClickListener {
            val biayaVariable = binding.etBiayaVariabel.text.toString().toDouble()
            val biayaTetap = binding.etBiayaTetap.text.toString().toDouble()
            val hargaPerunit = binding.etHargaPerunit.text.toString().toDouble()
            val biaya = input(biayaTetap,hargaPerunit,biayaVariable)
            val editText = FragmentEmpatDirections.actionFragmentEmpat3ToFragmentTiga(name,biaya)//parcelable
            it.findNavController().navigate(editText)
        }
    }

}

