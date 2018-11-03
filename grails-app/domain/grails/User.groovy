package grails

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    transient springSecurityService

    String username
    String password
    String cedula
    String nombre
    String apellido
    Date fechanacimiento
    String email
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static belongsTo = [Eventos]
    static hasMany = [eventos: Eventos]

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (this.isDirty('password')) { //TODO: verificar en en foro.
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }

    static transients = ['springSecurityService']

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        cedula nullable: false, blank: false, unique: true
        nombre nullable: false, blank: false
        apellido nullable: false, blank: false
        email email: true, nullable: false, blank: false
        fechanacimiento nullable: false, blank: false
    }

    static mapping = {
	    password column: '`password`'
    }
}
