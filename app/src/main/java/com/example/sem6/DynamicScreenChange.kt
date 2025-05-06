package com.example.sem6


import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
class DynamicScreenChange : AppCompatActivity() {
    private var isFragment = true
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dynamic_screen_change)
        var profile = findViewById<Button>(R.id.profile)
        profile.setOnClickListener {
            loadFragment(R.id.proframe,profileFragment())
        }
        var chat = findViewById<Button>(R.id.chat)
        chat.setOnClickListener {
                loadFragment(R.id.chatframe,chatFragment())
        }
        var camera = findViewById<Button>(R.id.camera)
        camera.setOnClickListener {
            loadFragment(R.id.camframe,cameraFragment())
        }
    }

    private fun loadFragment(layout:Int,fragment: Fragment) {
        val fragManager : androidx.fragment.app.FragmentManager = supportFragmentManager
        val change : androidx.fragment.app.FragmentTransaction = fragManager.beginTransaction()
        change.replace(layout,  fragment)
        change.commit()
    }
}