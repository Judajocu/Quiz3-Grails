package grails

class Eventos implements Serializable{

    String nombre
    String descripcion
    String fecha_inicio
    String fecha_fin
    int edad_permitida

    static hasMany = [usuarios: User]

    Set<User> getUsers()
    {

    }
    
    static constraints = {
        edad_permitida min: 0, max: 60
    }
}
