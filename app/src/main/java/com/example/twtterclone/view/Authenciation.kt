package com.example.twtterclone.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.twtterclone.view.fragemnt.SighnUpFragment

class Authenciation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authenciation_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SighnUpFragment.newInstance())
                .commitNow()
        }
    }
}