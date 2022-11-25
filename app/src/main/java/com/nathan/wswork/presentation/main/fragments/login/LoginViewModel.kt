package com.nathan.wswork.presentation.main.fragments.login

import androidx.lifecycle.ViewModel
import com.nathan.wswork.domain.repository.WSWRepository
import com.nathan.wswork.domain.model.User

class LoginViewModel (private val repository: WSWRepository) : ViewModel() {
    suspend fun getUser(email: String, password: String) : User {
        return repository.getUser(email, password)
    }

}