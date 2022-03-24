package com.example.challege3

import android.annotation.SuppressLint
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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //menerima data nama dari frag 2 ke 3 pake argumen
        val nama = args.name
        //menerima data fragmen 4 untuk menampilkan di xml
        val biaya = args.biaya
        if (biaya.biaya_tetap == 0.0){
            binding.tvJumlah.visibility = View.GONE//kondisi untuk menghilangkan jumlah dll saat frag 2 kirim frag 3
            binding.tvBiayaTetap.visibility = View.GONE
            binding.tvHargaPerunit.visibility = View.GONE
            binding.tvBiayaPerunit.visibility = View.GONE
            binding.tvNama.text = nama
        }else{
            val bep = biaya.biaya_tetap/(biaya.harga_perunit-biaya.biaya_variabel_perunit)//untuk menghitung
            binding.tvJumlah.text = "total semuanya ${bep.toString()}"
           binding.tvBiayaTetap.text = "masukan kuy : ${biaya.biaya_tetap.toString()}"
            binding.tvHargaPerunit.text="masukan harga : ${biaya.harga_perunit.toString()}"
            binding.tvBiayaPerunit.text="masukan biaya : ${biaya.biaya_variabel_perunit.toString()}"
            binding.btnThree.visibility = View.GONE//UNTUK MENGHILANGKAN BOTTOM SAAT FRAGMEN 4 KE 3
            binding.tvNama.text = nama
        }
        binding.btnThree.setOnClickListener {
                //kirim nama ke fragmen empat
                val send = FragmentTigaDirections.actionFragmentTigaToFragmentEmpat(nama)
                it.findNavController().navigate(send)//kirim data nama ke frag 4
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}