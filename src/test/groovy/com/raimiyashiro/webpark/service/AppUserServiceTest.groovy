package com.raimiyashiro.webpark.service

import com.raimiyashiro.webpark.repository.AppUserRepository
import com.raimiyashiro.webpark.repository.RoleRepository
import spock.lang.Specification
import spock.lang.Subject

import static com.raimiyashiro.webpark.TestConstants.ADMIN
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
        result.username == JOHN_DOE.username
    }

    def "SaveRole"() {
        given:
        1 * roleRepository.save(*_) >> ADMIN
        when:
        def result = service.saveRole(ADMIN)
        then:
        result == ADMIN
    }

    def "AddRoleToUser"() {
        // TODO: check why should think twice before using spies (and opting to change the design of the code under spec)
        given:
        def serviceSpy = Spy(service) {
            findUserByUsername(JOHN_DOE.username) >> JOHN_DOE
        }
        1 * roleRepository.findByName(*_) >> ADMIN
        1 * userRepository.save(*_) >> JOHN_DOE
        when:
        def result = serviceSpy.addRoleToUser(JOHN_DOE.username, ADMIN.name)
        then:
        result.roles.size() == 1
        result.roles.get(0) == ADMIN
    }
}
