package com.raimiyashiro.webpark.api

import com.raimiyashiro.webpark.domain.AppUser
import com.raimiyashiro.webpark.service.AppUserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AppUserResource(val userService: AppUserService) {

    @GetMapping("/users")
    fun getUsers(): Iterable<AppUser> = userService.findUsers()
}