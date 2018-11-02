package quiz3.grails

import grails.Role
import grails.User
import grails.UserRole

class BootStrap {

    def init = { servletContext ->

        User admin =new User(username: "GioGio", password: springSecurityService.encodePassword("1234")).save(failOnError: true)
        User user =new User(username: "JoJo", password: springSecurityService.encodePassword("1234")).save(failOnError: true)

        def roleAdmin = new Role(authority: "ROLE_ADMIN") .save(failOnError: true)
        def roleUsuario = new Role(authority: "ROLE_USUARIO").save(failOnError: true)

        UserRole.create(admin, roleAdmin);
        UserRole.create(user, roleUsuario);

    }
    def destroy = {
    }
}
