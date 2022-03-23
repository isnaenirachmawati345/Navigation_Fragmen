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
    //untuk menerima data nama dari fragmen 3
    val args : FragmentEmpatArgs by navArgs()
    companion object {
        val BIAYA_VARIABEL         = "BIAYA_VARIABEL"
        val HARGA_PERUNIT          = "HARGA_PERUNIT"
        val HARGA_VARIABEL_PERUNIT = "HARGA_VARIABEL_PERUNIT"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmpatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFour.setOnClickListener {
            val biayaVariable = binding.etBiayaVariabel.text.toString().toDouble()
            val biayaTetap = binding.etBiayaTetap.text.toString().toDouble()
            val hargaPerunit = binding.etHargaPerunit.text.toString().toDouble()
            val biaya = lainnya(biayaTetap,hargaPerunit,biayaVariable)
            val editText = FragmentEmpatDirections.actionFragmentEmpat3ToFragmentTiga(args.nama, biaya)
            it.findNavController().navigate(editText)
        }
    }

}

