package com.example.sem6

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Spinners : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinners)
        val destinationSpinner: Spinner = findViewById(R.id.spinner)
        val packageListView: ListView = findViewById(R.id.list1)

        val destinations = arrayOf("Paris", "New York", "Tokyo")
        val packagesForParis = arrayOf("Eiffel Tower", "Louvre Museum", "Seine River")
        val packagesForNewYork = arrayOf("Statue of Liberty", "Central Park", "Times Square")
        val packagesForTokyo = arrayOf("Tokyo Tower", "Mount Fuji", "Senso- ji Temple")

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,destinations)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        destinationSpinner.adapter = spinnerAdapter

        val initialAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, packagesForParis)
        packageListView.adapter = initialAdapter

        destinationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>,view: View?, position: Int, id: Long ) {
                val selectedPackages = when (position){
                    0 -> packagesForParis
                    1 -> packagesForNewYork
                    else -> packagesForTokyo
                }

                val ListAdapter = ArrayAdapter(this@Spinners, android.R.layout.simple_list_item_1, selectedPackages)
                packageListView.adapter = ListAdapter
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

    }
}