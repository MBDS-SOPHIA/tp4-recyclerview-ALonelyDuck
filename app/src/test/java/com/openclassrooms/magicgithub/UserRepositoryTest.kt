package com.openclassrooms.magicgithub

import com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS
import com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS_RANDOM
import com.openclassrooms.magicgithub.di.Injection
import com.openclassrooms.magicgithub.model.User
import com.openclassrooms.magicgithub.repository.UserRepository
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Unit test, which will execute on a JVM.
 * Testing UserRepository.
 */
@RunWith(JUnit4::class)
class UserRepositoryTest {
    private lateinit var userRepository: UserRepository

    @Before
    fun setup() {
        userRepository = Injection.getRepository()
    }

    @Test
    fun getUsersWithSuccess() {
        val usersActual = userRepository.getUsers()
        val usersExpected: List<User> = FAKE_USERS
        assertEquals(
            usersActual,
            usersExpected
        )
    }

    @Test
    fun generateRandomUserWithSuccess() {
        val initialSize = userRepository.getUsers().size
        userRepository.addRandomUser()
        val user = userRepository.getUsers().last()
        assertEquals(userRepository.getUsers().size, initialSize + 1)
        assertTrue(
            FAKE_USERS_RANDOM.filter {
                it.equals(user)
            }.isNotEmpty()
        )
    }

    @Test
    fun deleteUserWithSuccess() {
        val userToDelete = userRepository.getUsers()[0]
        userRepository.deleteUser(userToDelete)
        Assert.assertFalse(userRepository.getUsers().contains(userToDelete))
    }

    @Test
    fun toggleUserActivationWithSuccess() {
        val user = userRepository.getUsers()[0]
        val initialActivationState = user.isActive
        userRepository.toggleUserActivation(0)
        val userUpdated = userRepository.getUsers()[0]
        assertEquals(userUpdated.isActive, !initialActivationState)
    }

    @Test
    fun swapUsersWithSuccess() {
        val user1 = userRepository.getUsers()[0]
        val user2 = userRepository.getUsers()[1]
        userRepository.swapUsers(0, 1)
        assertEquals(userRepository.getUsers()[0], user2)
        assertEquals(userRepository.getUsers()[1], user1)
    }
}