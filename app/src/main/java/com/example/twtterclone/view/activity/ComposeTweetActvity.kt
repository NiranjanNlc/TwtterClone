package com.example.twtterclone.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.twtterclone.R
import com.example.twtterclone.databinding.ActivityComposeTweetActvityBinding
import android.widget.Toast
import com.example.twtterclone.util.RepoUtl
import com.example.twtterclone.viewModal.TweetViewModal
import com.example.twtterclone.viewModal.ViewModalFactory


class ComposeTweetActvity : AppCompatActivity()
{
    private lateinit var binding : ActivityComposeTweetActvityBinding
    private lateinit var viewmodel : TweetViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_compose_tweet_actvity)
        viewmodel = ViewModalFactory(RepoUtl.getRepo(this)).create(TweetViewModal::class.java)
        binding.viewmodel = viewmodel
        println(" composing the tweet ..............")
        binding.toolbar.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startHomeActivity()
            }
        })
        binding.btnTweet.setOnClickListener {
            viewmodel.insertTweet()
        }
        viewmodel.tweetmessage.observe(this,
            {
                if (it.equals("nepal3e4"))
                {
                    startHomeActivity()
                }
            })

    }

    private fun startHomeActivity() {
        val intent = Intent(this@ComposeTweetActvity, TimeLineActivity::class.java)
        startActivity(intent)
        Toast.makeText(applicationContext, "your icon was clicked", Toast.LENGTH_SHORT)
            .show()
    }
}
