package com.example.sem6

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Toast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_toast)
        val btn1=findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener{
            Toast.makeText(this, "Progress Bar",Toast.LENGTH_LONG).show()
        }
        val btn2=findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener{
            Toast.makeText(this, "ToolBar Bar",Toast.LENGTH_LONG).show()
        }
        val btn3=findViewById<Button>(R.id.btn3)
        btn3.setOnClickListener{
            Toast.makeText(this, "Rating Bar",Toast.LENGTH_LONG).show()
        }

    }
}