package com.example.challege3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.challege3.databinding.FragmentTigaBinding



class FragmentTiga : Fragment() {
    private  var _binding: FragmentTigaBinding? = null
    private val binding get() = _binding!!
    //menyimpn fragmen 4
    val args: FragmentTigaArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTigaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //menerima dengan dari bundel pake argumen
       // val myName = arguments?.getString(FragmentKedua.EXTRA_NAME)
        //binding.tvNama.text= myName
        //menerima data fragmen 4 untuk menampilkan di xml
        val nama = args.name
        val biaya = args.biaya
        //untuk menghitung
        if (biaya==null){
            binding.tvJumlah.visibility = View.GONE
            binding.tvBiayaTetap.visibility = View.GONE
            binding.tvHargaPerunit.visibility = View.GONE
            binding.tvBiayaPerunit.visibility = View.GONE
            binding.tvNama.text = nama
        }else{
            val bep = biaya.biaya_tetap/(biaya.harga_perunit-biaya.biaya_variabel_perunit)
            binding.tvJumlah.text = bep.toString()
            binding.tvBiayaTetap.text=biaya.biaya_tetap.toString()
            binding.tvHargaPerunit.text=biaya.harga_perunit.toString()
            binding.tvBiayaPerunit.text=biaya.biaya_variabel_perunit.toString()
            binding.tvNama.text = nama
        }
        binding.btnThree.setOnClickListener {
                //kirim nama ke fragmen empat
                var send = FragmentTigaDirections.actionFragmentTigaToFragmentEmpat(nama)
                it.findNavController().navigate(send)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}