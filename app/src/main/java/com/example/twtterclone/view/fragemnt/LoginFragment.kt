package com.example.twtterclone.view.fragemnt

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.twtterclone.R
import com.example.twtterclone.databinding.FragmentLoginBinding
import com.example.twtterclone.util.Extensions.toast
import com.example.twtterclone.view.activity.TimeLineActivity
import com.example.twtterclone.viewModal.AuthenciationViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    lateinit var modal : AuthenciationViewModel
    lateinit var builder: AlertDialog.Builder
    lateinit var dialog: AlertDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)
        modal =  ViewModelProvider (this).get(AuthenciationViewModel::class.java)
        builder = AlertDialog.Builder(requireContext())
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
                modal.sighIn()
            }
            else
            {
              displayLoginErrorMessage()
            }
        }
        modal.firebaseuser.observe(this,
            {
                if(it!=null) {
                    showTimeLine()
                }
            })
    }

    private fun showTimeLine() {
        val intent = Intent(activity, TimeLineActivity::class.java)
        startActivity(intent)
         toast(" Sucess fully logined ")
    }

    private fun displayLoginErrorMessage()
    {
        toast(" Erro ron login ")
    }

    private fun checkLoginScenario(): Boolean {
         return true
    }


}