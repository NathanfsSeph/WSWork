package com.nathan.wswork.data

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.nathan.wswork.data.database.WSWDatabase
import com.nathan.wswork.data.model.Lead

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
            println("Lead Worker - postLeads Try : ${savedLeads[0].userName} ")
            APIService.service.sendLeads(savedLeads)
            println("Pra fins acadêmicos")
        } catch (exception : Exception) {
            println("Lead Worker - postLeads Exception : ${exception.message} ")
        }

    }

    private fun loadLeads() : List<Lead> = WSWDatabase.getInstance(context).leadDao().get()
}