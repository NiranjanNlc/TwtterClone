package com.example.twtterclone.view.fragemnt

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.twtterclone.R
import com.example.twtterclone.viewModal.AuthenciationViewModel

class SighnUpFragment : Fragment() {

    companion object {
        fun newInstance() = SighnUpFragment()
    }

    private lateinit var viewModel: AuthenciationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.sighn_up_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthenciationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}