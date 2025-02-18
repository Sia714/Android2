package com.example.sem6

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class JobServicePlan : JobService(){
    override fun onStartJob(params: JobParameters?): Boolean {
        Log.d("MyJobService","Job started!")
        Thread{
            Thread.sleep(5000)
            Log.d("MyJobService","Job finished!")
            jobFinished(params,false)
        }.start()
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("MyJobService","Job stopped!")
        return false
    }
}