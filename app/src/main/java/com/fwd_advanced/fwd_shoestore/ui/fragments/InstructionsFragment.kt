package com.fwd_advanced.fwd_shoestore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.fwd_advanced.fwd_shoestore.R
import com.fwd_advanced.fwd_shoestore.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment() {
    lateinit var binding:FragmentInstructionsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_instructions, container, false)

        binding.instructionsFloatingActionButton.setOnClickListener {
            val action=InstructionsFragmentDirections.actionInstructionsFragmentToShoesListFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}