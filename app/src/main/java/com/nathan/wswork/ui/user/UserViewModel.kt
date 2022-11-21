package com.nathan.wswork.ui.user

import androidx.lifecycle.ViewModel
import com.nathan.wswork.data.database.WSWRepository
import com.nathan.wswork.data.model.User

class UserViewModel(private val repository: WSWRepository) : ViewModel() {

    suspend fun saveUser(newUser: User): Boolean {
        if (validatingData(newUser.firstName, newUser.firstName)) {
            repository.insertUser(newUser)
            return true
        } else return false
    }

    private fun validatingData(firstName: String, lastName: String): Boolean {

        return !(firstName.isNullOrEmpty() || lastName.isNullOrEmpty())
    }
}