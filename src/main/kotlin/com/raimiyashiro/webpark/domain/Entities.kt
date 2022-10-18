package com.raimiyashiro.webpark.domain

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
    val roles: List<Role>
)

@Entity
class Role(
    @Id @GeneratedValue
    val id: Long,
    @Column(nullable = false)
    val name: String
)