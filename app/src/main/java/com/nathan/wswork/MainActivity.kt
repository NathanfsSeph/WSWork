package com.nathan.wswork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Data
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.nathan.wswork.data.LeadWorker
import com.nathan.wswork.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.OffsetDateTime
import java.time.OffsetTime
import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getAllCars()
        setPeriodicWorkRequest()
    }

    private fun setPeriodicWorkRequest() {
        val periodicWorkRequest = PeriodicWorkRequest.Builder(LeadWorker::class.java, 15, TimeUnit.MINUTES).build()
        WorkManager.getInstance(applicationContext).enqueue(periodicWorkRequest)
    }

}