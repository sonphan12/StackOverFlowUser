package com.example.stackoverflowuser.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stackoverflowuser.R
import com.example.stackoverflowuser.data.RetrofitClient
import com.example.stackoverflowuser.data.SORepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var userAdapter: UserAdapter
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUserList()

        initViewModels()
        observeViewModels()
        viewModel.fetchUsers()
    }

    private fun initViewModels() {
        viewModel =
            MainViewModelFactory(SORepositoryImpl(RetrofitClient.soService)).create(MainViewModel::class.java)
    }

    private fun observeViewModels() {
        viewModel.usersLiveData.observe(this, Observer {
            userAdapter.users = it
        })

        viewModel.loadingLiveData.observe(this, Observer {
            loading.visibility = if (it) View.VISIBLE else View.GONE
        })
    }

    private fun initUserList() {
        val layoutManager = LinearLayoutManager(this)
        rvUser.layoutManager = layoutManager
        userAdapter = UserAdapter()
        rvUser.adapter = userAdapter
    }
}
