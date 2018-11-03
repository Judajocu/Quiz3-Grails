package quiz3.grails

import grails.Role
import grails.User
import grails.UserRole

class BootStrap {

    def springSecurityService

    def init = { servletContext ->

        def yesterday =new Date().plus(-30)
        User admin =new User(username: "GioGio",password: "1234", cedula: "0123456789", nombre: "Giorno", apellido: "Giovanna", fechanacimiento:yesterday, email: "Giogio@jojo.com" ).save(failOnError: true)
        User user =new User(username: "JoJo",nombre: "Jonathan", apellido: "Joestar", email: "jojo@jojo.com",fechanacimiento:yesterday, cedula: "987643210", password: "1234").save(failOnError: true)

        def roleAdmin = new Role(authority: "ROLE_ADMIN") .save(failOnError: true)
        def roleUsuario = new Role(authority: "ROLE_USUARIO").save(failOnError: true)

        UserRole.create(admin, roleAdmin);
        UserRole.create(user, roleUsuario);

    }
    def destroy = {
    }
}
