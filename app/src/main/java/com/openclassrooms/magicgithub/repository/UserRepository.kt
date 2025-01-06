package com.openclassrooms.magicgithub.repository

import com.openclassrooms.magicgithub.api.ApiService
import com.openclassrooms.magicgithub.model.User
import java.util.Collections

class UserRepository(private val apiService: ApiService) {

    fun getUsers(): List<User> {
        return apiService.getUsers()
    }

    fun addRandomUser() {
        apiService.addRandomUser()
    }

    fun deleteUser(user: User) {
        apiService.deleteUser(user)
    }

    fun toggleUserActivation(position: Int) {
        val user = apiService.getUsers()[position]
        user.isActive = !user.isActive
    }

    fun swapUsers(fromPosition: Int, toPosition: Int) {
        val users = apiService.getUsers() as MutableList<User>
        val temp = users[fromPosition]
        users[fromPosition] = users[toPosition]
        users[toPosition] = temp
        apiService.swapUsers(fromPosition, toPosition)
    }
}