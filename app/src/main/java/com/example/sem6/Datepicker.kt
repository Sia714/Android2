package com.example.sem6

import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Datepicker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_datepicker)
        var text=findViewById<TextView>(R.id.txtDate)
        var date=findViewById<DatePicker>(R.id.datePicker)
        val but=findViewById<Button>(R.id.button5)
        val calendar=Calendar.getInstance()
        val year= calendar.get(Calendar.YEAR)
        val month= calendar.get(Calendar.MONTH)
        val day= calendar.get(Calendar.DAY_OF_MONTH)
        date.init(year, month, day, null)

        but.setOnClickListener {
            val sely=date.year
            val selm=date.month
            val seld=date.dayOfMonth
            text.text="Date: $seld/$selm/$sely"
        }

    }
}