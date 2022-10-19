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

    fun saveUser(user: AppUser) {
        logger.info { "saving user ${user.name}" }
        userRepository.save(user)
    }

    fun saveRole(role: Role) {
        logger.info { "saving role ${role.name}" }
        roleRepository.save(role)
    }

    fun addRoleToUser(username: String, roleName: String) {
        logger.info { "saving role $roleName to user $username" }
        val user = findUserByUsername(username)!!
        val role = roleRepository.findByName(roleName)
        user.roles.add(role!!)
        userRepository.save(user)
    }
}