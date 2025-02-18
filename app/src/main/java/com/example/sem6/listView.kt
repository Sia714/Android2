package com.example.sem6

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class listView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        val list=findViewById<ListView>(R.id.list1)
        val arr= arrayOf("A","B","C","D","E","F","G","H","I")
        val mad=ArrayAdapter(this,android.R.layout.simple_list_item_1,arr)
        val Listfoot=layoutInflater.inflate(R.layout.footerlistview, list,false) as ViewGroup
        list.addFooterView(Listfoot)
        list.adapter=mad;
    }
}