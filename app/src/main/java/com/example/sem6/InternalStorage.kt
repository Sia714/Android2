package com.example.sem6

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.IOException

class InternalStorage : AppCompatActivity() {
    lateinit var sharedPreferences1: SharedPreferences
    lateinit var name: TextView
    lateinit var email: TextView
    val mypreference="mypref"
    val Name="namekey"
    val Email="emailkey"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_internal_storage)
        name = findViewById(R.id.editTextText)
        email = findViewById(R.id.editTextText2)
        //        Fetches the SharedPreferences instance using the name mypreference.
//        The Context.MODE_PRIVATE mode ensures that the shared preferences file is only accessible within the app.

        sharedPreferences1 = getSharedPreferences(mypreference, Context.MODE_PRIVATE)
        name.text = sharedPreferences1.getString(Name, "")
        email.text = sharedPreferences1.getString(Email, "")
    }
    fun save(view: View?){
       val n=name.text.toString()
       val e=email.text.toString()
        if(n.isEmpty() || e.isEmpty()){
            Toast.makeText(this,"Please Enter both name and email", Toast.LENGTH_LONG).show()
            return
        }
        //Calls edit() on sharedpreferences, which returns a SharedPreferences.Editor instance.
        //This editor allows us to modify the stored data.
//ONE WAY

//        val editor=sharedPreferences1.edit()
//       //stores the value of n under the key Name in SharedPreference
//        editor.putString(Name,n)
//        editor.putString(Email,e)
//        editor.apply()

        //apply() is preferred over commit() because:
//apply() saves the data in the background (non-blocking).
//apply() Saves the changes asynchronously.
//commit() is synchronous and blocks the main thread, which can slow down the UI.

        //SECOND ONE
        val data="$n\n\$e"
        try{
            openFileOutput(mypreference, MODE_PRIVATE).use{
                it.write(data.toByteArray())
            }
            Toast.makeText(this,"Email saved to internal storage", Toast.LENGTH_LONG).show()

        }catch (exp:IOException){
            exp.printStackTrace()
            Toast.makeText(this,"Error saving email", Toast.LENGTH_LONG).show()

        }
    }
    fun get(){
//        sharedPreferences1=getSharedPreferences(mypreference,Context.MODE_PRIVATE)
//        name.text=sharedPreferences1.getString(Name,"")
//        email.text=sharedPreferences1.getString(Email,"")
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