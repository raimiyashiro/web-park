package com.raimiyashiro.webpark.service

import com.raimiyashiro.webpark.domain.AppUser
import com.raimiyashiro.webpark.domain.Role
import com.raimiyashiro.webpark.repository.AppUserRepository
import com.raimiyashiro.webpark.repository.RoleRepository
import org.springframework.stereotype.Service

@Service
class AppUserService(val userRepository: AppUserRepository, val roleRepository: RoleRepository) {

    fun findUsers(): Iterable<AppUser> = userRepository.findAllByOrderByNameDesc()

    fun findUserByUsername(username: String): AppUser? = userRepository.findByUsername(username)

    fun saveUser(user: AppUser) {
        userRepository.save(user)
    }

    fun saveRole(role: Role) {
        roleRepository.save(role)
    }

    fun addRoleToUser(username: String, roleName: String) {
        val user = findUserByUsername(username)
        val role = roleRepository.findByName(roleName)
        user!!.roles.plus(role).distinct()
    }
}