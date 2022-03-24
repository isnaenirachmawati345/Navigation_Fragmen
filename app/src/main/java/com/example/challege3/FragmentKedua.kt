package com.example.challege3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.challege3.databinding.FragmentKeduaBinding



class FragmentKedua : Fragment() {
//    companion object{
//        const val EXTRA_NAME = "NAME"
//    }
    private var _binding: FragmentKeduaBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentKeduaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnTwo.setOnClickListener {
            if (binding.editTwo.text.isNotEmpty()){
                //UNTUK MENGIRIMKAN DATA PAKAI BUNDLE
//                val bundle = Bundle().apply {
//                    putString(EXTRA_NAME, binding.editTwo.text.toString())
//                }
             val fragmenduaKetiga = FragmentKeduaDirections.actionFragmentKeduaToFragmentTiga(binding.editTwo.text.toString(),input(0.0,0.0,0.0))//kirim kefragmen 3
                it.findNavController().navigate(fragmenduaKetiga)

            }


        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }




}

