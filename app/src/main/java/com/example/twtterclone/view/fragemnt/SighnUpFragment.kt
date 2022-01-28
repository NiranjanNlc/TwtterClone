package com.example.twtterclone.view.fragemnt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.twtterclone.R
import com.example.twtterclone.databinding.SighnUpFragmentBinding
import com.example.twtterclone.util.Extensions.toast
import com.example.twtterclone.viewModal.AuthenciationViewModel

class SighnUpFragment : Fragment() {

    private lateinit var binding: SighnUpFragmentBinding
    lateinit var modal : AuthenciationViewModel
    lateinit var builder: AlertDialog.Builder
    lateinit var dialog: AlertDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        binding = SighnUpFragmentBinding.inflate(layoutInflater,container,false)
        modal =  ViewModelProvider (this).get(AuthenciationViewModel::class.java)
        builder = AlertDialog.Builder(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCreate.setOnClickListener {
            loadingDialog()
            if(checkAllFieldNonEmpty() && checkPasswordMatch())
            {
               // modal.
            }
            else
            {
                displayErrorMessage()
            }
        }
    }

    private fun displayErrorMessage() {
        toast(" Error pn creating accunt")
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
    private fun loadingDialog(){
        builder.setView(layoutInflater.inflate(R.layout.activity_loading_layout,null))
        builder.setCancelable(false)
        dialog = builder.create()
        dialog.show()
    }
}