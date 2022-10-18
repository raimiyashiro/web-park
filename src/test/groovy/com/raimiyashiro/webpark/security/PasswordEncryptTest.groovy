package com.raimiyashiro.webpark.security

import spock.lang.Specification

class PasswordEncryptTest extends Specification {


    def "two plus two should be 4"(){
        given:
        def i = 2
        def j = 2
        when:
        def x = i + j
        then:
        x == 4
    }
}
