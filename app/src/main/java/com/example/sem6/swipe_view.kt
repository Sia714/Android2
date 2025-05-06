package com.example.sem6

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class swipe_view : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_swipe_view)
        viewPager=findViewById(R.id.view_pager)
        val tablay=findViewById<TabLayout>(R.id.tab_layout)
        val adapter=ViewGroup(this)
        viewPager.adapter=ViewGroup(this)
        TabLayoutMediator(tablay,viewPager){
            tab,position->tab.text=adapter.getTabTitle(position)
        }.attach()

    }
}