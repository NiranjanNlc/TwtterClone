package com.example.twtterclone.view.fragemnt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.twtterclone.R
import com.example.twtterclone.databinding.FragmentIntroductoryBinding
import com.example.twtterclone.databinding.FragmentLoginBinding
import com.example.twtterclone.databinding.SighnUpFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding.tvSignUp.setOnClickListener{
            it.findNavController().navigate(R.id.action_loginFragment_to_sighnUpFragment)
        }
    }



}