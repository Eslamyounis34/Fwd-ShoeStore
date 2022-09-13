package com.fwd_advanced.fwd_shoestore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.fwd_advanced.fwd_shoestore.R
import com.fwd_advanced.fwd_shoestore.databinding.FragmentAddShoeBinding
import com.fwd_advanced.fwd_shoestore.model.Shoe
import com.fwd_advanced.fwd_shoestore.viewmodels.ShoeViewModel


class AddShoeFragment : Fragment() {
    lateinit var binding: FragmentAddShoeBinding
    val viewModel: ShoeViewModel by activityViewModels()
    var shoe = Shoe("", "", "", "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_add_shoe, container, false)

        binding.shoeDetails = shoe

        binding.cancel.setOnClickListener {
            findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoesListFragment())
        }

        binding.save.setOnClickListener {
            saveButton()
        }

        return binding.root
    }


    private fun saveButton() {

        if (shoe.name.equals("") || shoe.company.equals("") || shoe.size.equals("") || shoe.desc.equals(
                ""
            )
        ) {
            Toast.makeText(context, "Please enter all shoe Data", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.addShoe(shoe)
            findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoesListFragment())
        }


    }

}