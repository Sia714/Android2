package com.example.sem6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class ExternalStorage : AppCompatActivity() {
    lateinit var uname:EditText
    lateinit var pwd:EditText
    lateinit var saveBtn:Button
    lateinit var fstream:FileOutputStream
    private var filename="SampleFile.txt"
    private var filepath="MyFileStorage"
    lateinit var myExternalFile:File


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_external_storage)
        uname=findViewById(R.id.txt)
        pwd=findViewById(R.id.secTxt)
        saveBtn=findViewById(R.id.saveBtn)
        saveBtn.setOnClickListener {
            val username="""
                $(uname.text)
            """.trimIndent()
            val password= pwd.text.toString()
            try{
                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(this, "All fields are necessary",Toast.LENGTH_SHORT).show()
                }
                else{
                    myExternalFile=File(getExternalFilesDir(filepath),filename)
                    fstream= FileOutputStream(myExternalFile)
                    fstream.write(username.toByteArray())
                    fstream.write(password.toByteArray())
                    fstream.close()
                    Toast.makeText(applicationContext,"Details Saved in "+myExternalFile!!.absolutePath,Toast.LENGTH_SHORT).show()
                    startActivity( Intent(this,ExternalDetails::class.java))
                }
            }catch (e: FileNotFoundException){
                e.printStackTrace()
            }catch (e: IOException){
                e.printStackTrace()
            }
        }
    }
}