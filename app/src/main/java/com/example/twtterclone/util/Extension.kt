package com.example.twtterclone.util

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment


object Extensions {
    fun Fragment.toast(msg: String){
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }

}