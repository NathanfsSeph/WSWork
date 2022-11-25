package com.nathan.wswork.ui.login

import androidx.lifecycle.ViewModel
import com.nathan.wswork.data.database.WSWRepository
import com.nathan.wswork.data.model.User

class LoginViewModel (private val repository: WSWRepository) : ViewModel() {
    suspend fun getUser(email: String, password: String) : User {
        return repository.getUser(email, password)
    }

}