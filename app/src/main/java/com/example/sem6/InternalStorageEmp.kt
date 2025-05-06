package com.example.sem6

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.IOException

class InternalStorageEmp : AppCompatActivity() {
    lateinit var sharedPreferences1: SharedPreferences
    lateinit var name: TextView
    lateinit var email: TextView
    val mypreference="empData"
    val Name="namekey"
    val Id="Idkey"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_internal_storage_emp)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun save(view: View?){
        val n=name.text.toString()
        val e=email.text.toString()
        if(n.isEmpty() || e.isEmpty()){
            Toast.makeText(this,"Please Enter both name and email", Toast.LENGTH_LONG).show()
            return
        }

        val data="$n\n\$e"
        try{
            openFileOutput(mypreference, MODE_PRIVATE).use{
                it.write(data.toByteArray())
            }
            Toast.makeText(this,"Email saved to internal storage", Toast.LENGTH_LONG).show()

        }catch (exp: IOException){
            exp.printStackTrace()
            Toast.makeText(this,"Error saving email", Toast.LENGTH_LONG).show()

        }
    }
    fun get(){
        openFileInput(mypreference).use { stream ->
            val lines = stream.bufferedReader().readLines()
            if (lines.size >= 2) {
                name.setText(lines[0])
                email.setText(lines[1])
                Toast.makeText(this, "Email loaded", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, "No data to load", Toast.LENGTH_LONG).show()

            }
        }
    }
    fun clear(){
        name.text=""
        email.text=""
    }
}