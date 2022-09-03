package com.example.databinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var user: User? = null
    private var userList = ArrayList<User>()
    private lateinit var manager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.
            setContentView(this,R.layout.activity_main)
        user = User("Ibaad","ibad@milkywaytrading.co.uk")
        binding.setUser(user)
        var data = listOf(DataModel(1, "First data"),DataModel(2, "Second data"),DataModel(3, "Third data"),DataModel(4, "Fourth data"),DataModel(5, "Fifth data"))

       manager = LinearLayoutManager(this)
        binding.recyData.apply {
            adapter = dataAdapter(data)
            layoutManager=manager
        }

    }

}