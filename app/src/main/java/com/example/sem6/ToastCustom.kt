package com.example.sem6

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ToastCustom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_toast_custom)
        val but=findViewById<Button>(R.id.but)
        but.setOnClickListener{
            val lay=layoutInflater.inflate(R.layout.toastimage,null)
            val toast=Toast(applicationContext)
            toast.setGravity(Gravity.BOTTOM,0,20)
            toast.duration=Toast.LENGTH_LONG
            toast.view=lay
            toast.show()
        }
//         OR
//        but.setOnClickListener{
//            Toast(applicationContext).apply {
//                view = layoutInflater.inflate(R.layout.toastimage, null)
//                setGravity(Gravity.BOTTOM, 0, 20)
//                duration = Toast.LENGTH_LONG
//                show()
//            }
//        }
    }
}