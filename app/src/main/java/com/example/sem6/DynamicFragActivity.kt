package com.example.sem6

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class DynamicFragActivity : AppCompatActivity() {
    private var isFragment=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dynamic_frag)
        val btn=findViewById<Button>(R.id.btn)
        btn.setOnClickListener{
            if(isFragment){
                loadFragment(dfrag2())
            }
            else{
                loadFragment(dfrag1())
            }
            isFragment = !isFragment
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fragManager:FragmentManager=supportFragmentManager
        val change:FragmentTransaction=fragManager.beginTransaction()
        change.replace(R.id.frame,fragment)
        change.commit()
    }
}