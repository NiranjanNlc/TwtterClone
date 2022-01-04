package com.example.twtterclone.view.fragemnt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.findNavController
import com.example.twtterclone.R
import com.example.twtterclone.databinding.FragmentIntroductoryBinding


class IntroductoryFragment : Fragment() {

   private lateinit var binding : FragmentIntroductoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIntroductoryBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCreateAccount.setOnClickListener {
            it.findNavController().navigate(R.id.action_introductoryFragment_to_sighnUpFragment)
        }
        binding.tvLogin.setOnClickListener {
            it.findNavController().navigate(R.id.action_introductoryFragment_to_loginFragment)
        }
    }
}