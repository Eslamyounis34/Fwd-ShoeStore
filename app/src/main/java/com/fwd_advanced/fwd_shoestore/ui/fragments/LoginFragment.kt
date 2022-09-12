package com.fwd_advanced.fwd_shoestore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.fwd_advanced.fwd_shoestore.R
import com.fwd_advanced.fwd_shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.loginBt.setOnClickListener {
         login()
        }

        binding.signUpButton.setOnClickListener {
            login()
        }
        return binding.root
    }

    private fun login(){
        var userName = binding.userNameEditText.text.toString()
        var password = binding.passwordEditText.text.toString()

        if (userName.equals("") || password.equals("")) {
            Toast.makeText(context, getString(R.string.login_fail_msg), Toast.LENGTH_SHORT)
                .show()
        }
        else{
            val action=LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
            findNavController().navigate(action)
        }
    }

}