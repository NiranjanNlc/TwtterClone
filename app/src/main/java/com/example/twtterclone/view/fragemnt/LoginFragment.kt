package com.example.twtterclone.view.fragemnt

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.twtterclone.R
import com.example.twtterclone.databinding.FragmentLoginBinding
import com.example.twtterclone.view.TimeLineActivity

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
        binding.btnLogin.setOnClickListener {
            if (checkLoginScenario())
            {
                showTimeLine()
            }
            else
            {
              displayLoginErrorMessage()
            }
        }
    }

    private fun showTimeLine() {
        val intent = Intent(activity, TimeLineActivity::class.java)
        startActivity(intent)
        Toast.makeText(context, "your icon was clicked", Toast.LENGTH_SHORT)
            .show()
    }

    private fun displayLoginErrorMessage() {
        TODO("Not yet implemented")
    }

    private fun checkLoginScenario(): Boolean {
         return true

    }


}