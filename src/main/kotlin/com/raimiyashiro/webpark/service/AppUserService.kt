package com.raimiyashiro.webpark.service

import com.raimiyashiro.webpark.domain.AppUser
import com.raimiyashiro.webpark.domain.Role
import com.raimiyashiro.webpark.repository.AppUserRepository
import com.raimiyashiro.webpark.repository.RoleRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class AppUserService(val userRepository: AppUserRepository, val roleRepository: RoleRepository) {

    fun findUsers(): Iterable<AppUser> = userRepository.findAllByOrderByNameDesc()

    fun findUserByUsername(username: String): AppUser? = userRepository.findByUsername(username)

    fun saveUser(user: AppUser): AppUser {
        logger.info { "saving user ${user.name}" }
        return userRepository.save(user)
    }

    fun saveRole(role: Role): Role {
        logger.info { "saving role ${role.name}" }
        return roleRepository.save(role)
    }

    fun addRoleToUser(username: String, roleName: String) : AppUser {
        // TODO: understand Kotlin Null Safety
        logger.info { "saving role $roleName to user $username" }
        val user = findUserByUsername(username)!!
        val role = roleRepository.findByName(roleName)
        user.roles.add(role!!)
        return userRepository.save(user)
    }
}