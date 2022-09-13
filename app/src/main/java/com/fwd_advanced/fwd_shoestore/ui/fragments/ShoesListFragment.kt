package com.fwd_advanced.fwd_shoestore.ui.fragments

import android.R.attr.*
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginBottom
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.fwd_advanced.fwd_shoestore.R
import com.fwd_advanced.fwd_shoestore.databinding.FragmentShoesListBinding
import com.fwd_advanced.fwd_shoestore.model.Shoe
import com.fwd_advanced.fwd_shoestore.viewmodels.ShoeViewModel


class ShoesListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentShoesListBinding
    val viewModel: ShoeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoes_list, container, false)

        setHasOptionsMenu(true)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoesList ->
            Log.e("testList", shoesList.toString())
            for (i in shoesList) {
                addShoeView(i)
            }
        })

        binding.addShoeDetails.setOnClickListener {
            findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToAddShoeFragment())
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater!!.inflate(R.menu.app_menu, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToLoginFragment())
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addShoeView(shoe: Shoe) {
        val item = LinearLayout(context)

        item.setBackgroundColor(resources.getColor(R.color.teal_200))
        val params = FrameLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(5, 10, 5, 10)
        item.setLayoutParams(params)

        var name = TextView(context)
        var company = TextView(context)
        var size = TextView(context)
        var desc = TextView(context)

        name.text = shoe.name
        company.text = shoe.company
        size.text = shoe.size.toString()
        desc.text = shoe.desc

        name.textSize = 20f
        name.gravity = Gravity.CENTER_HORIZONTAL
        name.setTextColor(getResources().getColor(R.color.white))
        name.setTypeface(null, Typeface.BOLD)

        company.textSize = 20f
        company.gravity = Gravity.CENTER_HORIZONTAL
        company.setTextColor(getResources().getColor(R.color.white))
        company.setTypeface(null, Typeface.BOLD)

        size.textSize = 20f
        size.gravity = Gravity.CENTER_HORIZONTAL
        size.setTextColor(getResources().getColor(R.color.white))
        size.setTypeface(null, Typeface.BOLD)

        desc.textSize = 20f
        desc.gravity = Gravity.CENTER_HORIZONTAL
        desc.setTextColor(getResources().getColor(R.color.white))
        desc.setTypeface(null, Typeface.BOLD)

        item.setOrientation(LinearLayout.VERTICAL)
        item.addView(name)
        item.addView(company)
        item.addView(size)
        item.addView(desc)

        binding.shoeList.addView(item);

    }

}