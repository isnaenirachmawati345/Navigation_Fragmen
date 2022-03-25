package com.example.challege3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.challege3.databinding.FragmentEmpatBinding

class FragmentEmpat : Fragment() {
    private lateinit var binding: FragmentEmpatBinding
    //untuk menerima data nama dari fragmen 3 menggunakan argumen
    private val args : FragmentEmpatArgs by navArgs()

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
            if (binding.etBiayaTetap.text.isNotEmpty() || binding.etHargaPerunit.text.isNotEmpty() || binding.etBiayaVariabel.text.isNotEmpty()) {
                val biayaTetap = binding.etBiayaTetap.text.toString().toInt()
                val hargaPerunit = binding.etHargaPerunit.text.toString().toInt()
                val biayaVariable = binding.etBiayaVariabel.text.toString().toInt()
                val biaya = input(biayaTetap, biayaVariable, hargaPerunit)
                val editText = FragmentEmpatDirections.actionFragmentEmpat3ToFragmentTiga(name,biaya)//parcelable
                it.findNavController().navigate(editText)
            } else {
                Toast.makeText(context, "Harap Masukan Data Anda Kembali", Toast.LENGTH_SHORT).show()
            }
        }
    }

}

