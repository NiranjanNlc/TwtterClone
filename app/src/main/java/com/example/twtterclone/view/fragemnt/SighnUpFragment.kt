package com.example.twtterclone.view.fragemnt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.twtterclone.R
import com.example.twtterclone.databinding.FragmentIntroductoryBinding
import com.example.twtterclone.databinding.SighnUpFragmentBinding

class SighnUpFragment : Fragment() {

    private lateinit var binding: SighnUpFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        // Inflate the layout for this fragment
        binding = SighnUpFragmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCreate.setOnClickListener {
            if(checkAllFieldNonEmpty() && checkPasswordMatch())
            {

            }
            else
            {
                displayErrorMessage()
            }
        }
    }

    private fun displayErrorMessage() {
        TODO("Not yet implemented")
    }

    private fun checkPasswordMatch(): Boolean
    {
       if(binding.confirmPassword.text.equals(binding.etPassword.text))
           return true
        else
            return false
    }

    private fun checkAllFieldNonEmpty(): Boolean
    {
        return true
    }
}