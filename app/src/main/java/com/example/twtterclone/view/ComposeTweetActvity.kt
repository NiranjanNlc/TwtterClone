package com.example.twtterclone.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.twtterclone.R
import com.example.twtterclone.databinding.ActivityComposeTweetActvityBinding
import com.example.twtterclone.databinding.ActivityMainBinding
import android.widget.Toast




class ComposeTweetActvity : AppCompatActivity()
{
    private lateinit var binding : ActivityComposeTweetActvityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_compose_tweet_actvity)
        binding.toolbar.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@ComposeTweetActvity,MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(applicationContext, "your icon was clicked", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}
