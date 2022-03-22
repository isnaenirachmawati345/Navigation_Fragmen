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
        val myName = args.name
        binding.editThree.text= myName
        binding.btnTwo.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentTiga_to_fragmentEmpat3)
        }
    }

}