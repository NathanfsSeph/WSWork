package com.nathan.wswork.data

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.nathan.wswork.data.localdatasource.WSWDatabase
import com.nathan.wswork.data.remotedatasource.APIService
import com.nathan.wswork.domain.model.Lead

class LeadWorker(
    private val context: Context,
    private val workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        postLeads()
        return Result.retry()
    }

    private fun postLeads() {
        try {
            val savedLeads = loadLeads()
            APIService.service.sendLeads(savedLeads)
        } catch (exception : Exception) {
            println("Lead Worker - postLeads Exception : ${exception.message} ")
        }

    }

    private fun loadLeads() : List<Lead> = WSWDatabase.getInstance(context).leadDao().get()
}