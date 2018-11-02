package quiz3.grails

import grails.Role
import grails.User
import grails.UserRole

class BootStrap {

    def springSecurityService

    def init = { servletContext ->

        User admin =new User(username: "GioGio",password: springSecurityService.encodePassword("1234"), cedula: "0123456789", nombre: "Giorno", apellido: "Giovanna", fechanacimiento: "10/10/1980", email: "Giogio@jojo.com" ).save(failOnError: true)
        User user =new User(username: "JoJo",nombre: "Jonathan", apellido: "Joestar", email: "jojo@jojo.com",fechanacimiento: "10/10/1990", cedula: "987643210", password: springSecurityService.encodePassword("1234")).save(failOnError: true)

        def roleAdmin = new Role(authority: "ROLE_ADMIN") .save(failOnError: true)
        def roleUsuario = new Role(authority: "ROLE_USUARIO").save(failOnError: true)

        UserRole.create(admin, roleAdmin);
        UserRole.create(user, roleUsuario);

    }
    def destroy = {
    }
}
