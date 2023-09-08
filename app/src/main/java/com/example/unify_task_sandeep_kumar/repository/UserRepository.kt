package com.example.unify_task_sandeep_kumar.repository

import com.example.unify_task_sandeep_kumar.api.ApiInterface
import com.example.unify_task_sandeep_kumar.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class UserRepository @Inject constructor(private var apiInterface: ApiInterface) {


    private var _users: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())

    val users: StateFlow<List<User>>
        get() = _users

    /**
     * here fetching the data from SERVER
     */
    suspend fun getUsers() {

        try {
            val response = apiInterface.getUsers()

            if (response.isSuccessful && response.body() != null) {

                _users.emit(response.body()!!)
            }
        } catch (e: Exception) {
            _users.emit(emptyList())
        }
    }
}