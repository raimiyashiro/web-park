package com.raimiyashiro.webpark.api

import com.raimiyashiro.webpark.domain.AppUser
import com.raimiyashiro.webpark.domain.Role
import com.raimiyashiro.webpark.dto.UserRoleForm
import com.raimiyashiro.webpark.service.AppUserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AppUserResource(val userService: AppUserService) {

    @GetMapping("/users")
    fun getUsers(): Iterable<AppUser> = userService.findUsers()

    @PostMapping("/users")
    fun saveUsers(@RequestBody user: AppUser) {
        userService.saveUser(user)
    }

    @PostMapping("/roles")
    fun saveRoles(@RequestBody role: Role) {
        userService.saveRole(role)
    }

    @PostMapping("/users/roles")
    fun assignRoleToUser(@RequestBody userRoleForm: UserRoleForm) {
        userService.addRoleToUser(userRoleForm.username, userRoleForm.roleName)
    }
}