package com.example.stackoverflowuser.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stackoverflowuser.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUserList()
    }

    private fun initUserList() {
        val layoutManager = LinearLayoutManager(this)
        rvUser.layoutManager = layoutManager
        userAdapter = UserAdapter()
        rvUser.adapter = userAdapter
    }
}
