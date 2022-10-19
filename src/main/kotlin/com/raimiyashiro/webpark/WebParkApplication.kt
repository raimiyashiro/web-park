package com.raimiyashiro.webpark

import com.raimiyashiro.webpark.domain.AppUser
import com.raimiyashiro.webpark.domain.Role
import com.raimiyashiro.webpark.repository.AppUserRepository
import com.raimiyashiro.webpark.repository.RoleRepository
import com.raimiyashiro.webpark.service.AppUserService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class WebParkApplication {

    @Bean
    fun init(userService: AppUserService, userRepository: AppUserRepository, roleRepository: RoleRepository) =
        CommandLineRunner {

            userRepository.deleteAll()
            roleRepository.deleteAll()

            userService.saveRole(Role(1, "admin"))
            userService.saveRole(Role(2, "user"))
            userService.saveRole(Role(3, "super"))
            userService.saveRole(Role(4, "tester"))

            userService.saveUser(AppUser(1, "John", "john@doe.io", "12345", mutableListOf()))
            userService.saveUser(AppUser(2, "Jhin", "jhin@doe.io", "12345", mutableListOf()))
            userService.saveUser(AppUser(3, "Jay", "jay@doe.io", "12345", mutableListOf()))
            userService.saveUser(AppUser(4, "Jack", "jack@doe.io", "12345", mutableListOf()))

            userService.addRoleToUser("john@doe.io", "admin")
            userService.addRoleToUser("jhin@doe.io", "user")
            userService.addRoleToUser("jay@doe.io", "super")
            userService.addRoleToUser("jack@doe.io", "tester")
            userService.addRoleToUser("jack@doe.io", "admin")
        }
}

fun main(args: Array<String>) {
    SpringApplication.run(WebParkApplication::class.java, *args)
}