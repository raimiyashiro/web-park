package com.raimiyashiro.webpark.repository

import com.raimiyashiro.webpark.domain.AppUser
import com.raimiyashiro.webpark.domain.Role
import org.springframework.data.repository.CrudRepository

interface AppUserRepository : CrudRepository<AppUser, Long> {
    fun findByUsername(username: String): AppUser?
    fun findAllByOrderByNameDesc(): Iterable<AppUser>
}

interface RoleRepository : CrudRepository<Role, Long> {
    fun findAllByOrderByNameDesc(): Iterable<Role>
}