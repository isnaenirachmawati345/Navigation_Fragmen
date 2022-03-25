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
    private val args: FragmentTigaArgs by navArgs()
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
        if (biaya.biayaTetap == 0){
            binding.tvJumlah.visibility = View.GONE//kondisi untuk menghilangkan jumlah dll saat frag 2 kirim frag 3
            binding.tvBiayaTetap.visibility = View.GONE
            binding.tvHargaPerunit.visibility = View.GONE
            binding.tvBiayaPerunit.visibility = View.GONE
            binding.tvNama.text = nama
        }else{
            val bep = biaya.biayaTetap/(biaya.biayaVariabelPerunit-biaya.hargaPerunit)//untuk menghitung
            binding.tvJumlah.text = "Total Break Even Point Kamu:  Rp.${bep.toString().toInt()}"
           binding.tvBiayaTetap.text = "Biaya Tetap Sebanyak Kamu: Rp.${biaya.biayaTetap.toString().toInt()}"
            binding.tvBiayaPerunit.text="Biaya Per-Unit Sebanyak Kamu : Rp.${biaya.biayaVariabelPerunit.toString().toInt()}"
            binding.tvHargaPerunit.text="Harga Per-Unit Sebanyak Kamu: Rp.${biaya.hargaPerunit.toString().toInt()}"
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
//    private fun currency(angka: Int): String {
//        val kursIndonesia = DecimalFormat.getCurrencyInstance() as DecimalFormat
//        val formatRp = DecimalFormatSymbols()
//        formatRp.currencySymbol = "Rp "
//        formatRp.monetaryDecimalSeparator = ','
//        formatRp.groupingSeparator = '.'
//        kursIndonesia.decimalFormatSymbols = formatRp
//        return kursIndonesia.format(angka)
 //   }



}