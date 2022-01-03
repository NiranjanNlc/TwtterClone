package com.example.twtterclone.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.twtterclone.R
import com.example.twtterclone.databinding.ActivityMainBinding
import com.example.twtterclone.util.RepoUtl
import com.example.twtterclone.view.adapter.TweetAdapter
import com.example.twtterclone.viewModal.TimeLineViewModal
import com.example.twtterclone.viewModal.ViewModalFactory

class TimeLineActivity : AppCompatActivity()
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
        binding.recyclerview.layoutManager= LinearLayoutManager(this)
        timeLineViewModal.tweets.observe(this,
            {
                println(it.toString())
                adapter.submitList(it)
            })
    }
}