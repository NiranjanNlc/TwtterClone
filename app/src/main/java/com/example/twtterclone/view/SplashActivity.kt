package com.example.twtterclone.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SplashActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        if (isUserLoggedIn())
        {
            startHomeActivity()
        }
        else
        {

        }
    }

    private fun isUserLoggedIn(): Boolean
    {
       return true
    }
    private fun startHomeActivity() {
        val intent = Intent(this, TimeLineActivity::class.java)
        startActivity(intent)
        Toast.makeText(applicationContext, "your icon was clicked", Toast.LENGTH_SHORT)
            .show()
    }
}