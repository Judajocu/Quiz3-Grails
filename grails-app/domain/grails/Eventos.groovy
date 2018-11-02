package grails

class Eventos implements Serializable{

    String nombre
    String descripcion
    Date fecha_inicio
    Date fecha_fin
    int edad_permitida
    
    static constraints = {
    }
}
