package com.example.sem6

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class progress : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_progress)
        val btn=findViewById<Button>(R.id.but)
        val progress=findViewById<ProgressBar>(R.id.pro)
        btn.setOnClickListener{
            progress.visibility= View.VISIBLE
            btn.isEnabled=false

        }
    }
}