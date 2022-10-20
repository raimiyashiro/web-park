package com.raimiyashiro.webpark.service

import com.raimiyashiro.webpark.domain.AppUser
import com.raimiyashiro.webpark.repository.AppUserRepository
import com.raimiyashiro.webpark.repository.RoleRepository
import spock.lang.Specification
import spock.lang.Subject

import static com.raimiyashiro.webpark.TestConstants.JOHN_DOE


class AppUserServiceTest extends Specification {

    def userRepository = Mock(AppUserRepository)
    def roleRepository = Mock(RoleRepository)


    @Subject
    def service = new AppUserService(userRepository, roleRepository)

    def "FindUsers"() {
        given:
        1 * userRepository.findAllByOrderByNameDesc() >> [JOHN_DOE]
        when:
        def result = service.findUsers()
        then:
        result.size() == 1
    }

    def "FindUserByUsername"() {
        given:
        1 * userRepository.findByUsername(*_) >> JOHN_DOE
        when:
        def result = service.findUserByUsername(JOHN_DOE.username)
        then:
        result.username == JOHN_DOE.username
    }

    def "SaveUser"() {
        given:
        1 * userRepository.save(*_) >> JOHN_DOE
        when:
        def result = service.saveUser(JOHN_DOE)
        then:
        result.username == JOHN_DOE.username}

    def "SaveRole"() {
    }

    def "AddRoleToUser"() {
    }

    def "GetUserRepository"() {
    }

    def "GetRoleRepository"() {
    }
}
