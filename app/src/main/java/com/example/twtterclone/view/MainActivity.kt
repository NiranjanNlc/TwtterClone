package com.example.twtterclone.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.twtterclone.R
import com.example.twtterclone.databinding.ActivityMainBinding
import com.example.twtterclone.util.RepoUtl
import com.example.twtterclone.viewModal.TimeLineViewModal
import com.example.twtterclone.viewModal.ViewModalFactory

class MainActivity : AppCompatActivity()
{
    private lateinit var binding : ActivityMainBinding;
    private lateinit var timeLineViewModal: TimeLineViewModal
    private lateinit var adapter: TweetAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        timeLineViewModal = ViewModalFactory(RepoUtl.getRepo(this)).create(TimeLineViewModal::class.java)
        binding.fabCompose.setOnClickListener {
            val intent = Intent(this, ComposeTweetActvity::class.java)
            startActivity(intent)
        }
        adapter = TweetAdapter()
        binding.recyclerview.adapter = adapter
    }
}