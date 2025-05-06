package com.example.sem6

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class datatransfer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_datatransfer)
        val fragManager : androidx.fragment.app.FragmentManager = supportFragmentManager
        val change : androidx.fragment.app.FragmentTransaction = fragManager.beginTransaction()
        // Replace the fragment in the container
        change.replace(R.id.fragmentleft,  leftFrag())
        change.commit()

        val fragManager1 : androidx.fragment.app.FragmentManager = supportFragmentManager
        val change1 : androidx.fragment.app.FragmentTransaction = fragManager1.beginTransaction()
        // Replace the fragment in the container
        change1.replace(R.id.fragmentright,  rightFrag())
        change1.commit()
    }
}