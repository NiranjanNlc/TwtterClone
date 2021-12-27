package com.example.twtterclone.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.twtterclone.databinding.TweetItemBinding
import com.example.twtterclone.model.data.Tweet

class TweetAdapter: ListAdapter<Tweet, TweetAdapter.TweetViewHolder>(TWEET_COMPARATOR)
{
    companion object {
        val TWEET_COMPARATOR = object : DiffUtil.ItemCallback<Tweet>() {
            override fun areItemsTheSame(oldItem: Tweet, newItem: Tweet): Boolean {
                println(" item same ")
                return oldItem == newItem;
            }

            override fun areContentsTheSame(oldItem: Tweet, newItem: Tweet): Boolean {
                print(" Content same ")
                return oldItem.statusid.equals(newItem.statusid)
            }
        }
    }
    class TweetViewHolder (var binding: TweetItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder
    {
        println("On view create ")
        val inflater = LayoutInflater.from(parent.context)
        val binding = TweetItemBinding.inflate(inflater)
        return TweetViewHolder(binding)
    }
    override fun onBindViewHolder(holder: TweetViewHolder, position: Int)
    {
        println("On view bind"+getItem(position).message)
        holder.binding.tweet = getItem(position)
        holder.binding.executePendingBindings()
    }
}