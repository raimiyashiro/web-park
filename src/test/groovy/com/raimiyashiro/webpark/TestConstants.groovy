package com.raimiyashiro.webpark

import com.raimiyashiro.webpark.domain.AppUser
import com.raimiyashiro.webpark.domain.Role

class TestConstants {
    def static final JOHN_DOE = new AppUser(1, "John", "john@doe.io", "12345", [])
    def static final ADMIN = new Role(2, "admin", [])
}
