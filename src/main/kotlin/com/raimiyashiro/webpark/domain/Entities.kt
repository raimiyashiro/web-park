package com.raimiyashiro.webpark.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
class AppUser(
    @Id @GeneratedValue
    val id: Long,
    @Column(nullable = false)
    val name: String,
    @Column(nullable = false)
    val username: String,
    @Column(nullable = false)
    val password: String,
    @ManyToMany(fetch = FetchType.EAGER)
    var roles: MutableList<Role> = mutableListOf()
)

@Entity
class Role(
    @Id @GeneratedValue
    val id: Long,
    @Column(nullable = false)
    val name: String,
    @ManyToMany
    var users: MutableList<AppUser> = mutableListOf()
)
