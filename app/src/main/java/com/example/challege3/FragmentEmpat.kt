package com.example.challege3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.challege3.databinding.FragmentEmpatBinding

class FragmentEmpat : Fragment() {
    private lateinit var binding: FragmentEmpatBinding
    companion object {
        val AGE = "AGE"
        val ADDRESS = "ADDRESS"
        val JOB = "JOB"
        val BUNDLE ="Bungkusan"
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
//            val age = binding.etAge.text.toString().toInt()
//            val address = binding.etAddress.text.toString()
//            val job = binding.etJob.text.toString()
//            val bundleSaya = Bundle().apply {
//                putInt(AGE, age)
//                putString(ADDRESS, address)
//                putString(JOB, job)
//            }
//            val intentBundle = Intent(this, FragmentTiga::class.java).apply {
//                putExtra
//            }
//            startActivity(intentBundle)
//        }
            //pindah halaman
            val editText = FragmentEmpatDirections.actionFragmentEmpat3ToFragmentTiga(binding.etAge.text.toString())
            it.findNavController().navigate(editText)

        }
    }

}

