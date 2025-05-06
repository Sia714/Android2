package com.example.sem6

import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TimePicker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_time_picker)
        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        val btnShowTime = findViewById<Button>(R.id.btnShowTime)

        btnShowTime.setOnClickListener {
            val hour = timePicker.hour
            val minute = timePicker.minute

            val selectedTime = String.format("%02d:%02d", hour, minute)
            Toast.makeText(this, "Selected Time: $selectedTime", Toast.LENGTH_SHORT).show()
        }

    }
}