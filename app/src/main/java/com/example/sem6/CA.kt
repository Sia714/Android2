package com.example.sem6

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class CA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ca)
        val btn=findViewById<Button>(R.id.button)
        val list=findViewById<ListView>(R.id.List)
        val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

        val arr = arrayOf("16:41:01", "16:41:14", "16:41:26", "16:41:45")

        val classDateTimes = arr.map {
            timeFormat.parse(it)
        }.toTypedArray()


        val ada= ArrayAdapter(this,android.R.layout.simple_list_item_1,arr)
        list.adapter=ada;
        btn.setOnClickListener{
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.S){
                val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
                if (!alarmManager.canScheduleExactAlarms()) {
                    val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM)
                    startActivity(intent)
                    Toast.makeText(this, "Permission Not Granted", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
            }
            for (timeStr in arr) {
                val classTime = timeFormat.parse(timeStr)

                if (classTime != null) {
                    val currentTime = System.currentTimeMillis()

                    val calendar = Calendar.getInstance()
                    calendar.time = Date(currentTime)
                    calendar.set(Calendar.HOUR_OF_DAY, classTime.hours)
                    calendar.set(Calendar.MINUTE, classTime.minutes)
                    calendar.set(Calendar.SECOND, 0)
                    calendar.set(Calendar.MILLISECOND, 0)

                    var triggerTime = calendar.timeInMillis

                    val delay = if (triggerTime > currentTime) {
                        triggerTime - currentTime
                    } else {
                        triggerTime + 24 * 60 * 60 * 1000 - currentTime
                    }

                    setAlarm(delay)
                }
            }
            Toast.makeText(this, "Alarm set for upcoming classes", Toast.LENGTH_LONG).show()
        }


    }

    private fun setAlarm(delay:Long) {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmManagerReceiver::class.java).apply{
            action = "com.example.ALARM_TRIGGERED"
        }
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val triggerTime = System.currentTimeMillis() + delay

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                triggerTime,
                pendingIntent
            )
        }
    }

}