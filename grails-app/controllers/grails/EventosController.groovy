package grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EventosController {

    EventosService eventosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond eventosService.list(params), model:[eventosCount: eventosService.count()]
    }

    def show(Long id) {
        respond eventosService.get(id)
    }

    def create() {
        respond new Eventos(params)
    }

    def save(Eventos eventos) {
        if (eventos == null) {
            notFound()
            return
        }

        println("esto: "+eventos.nombre)
        for(eve in eventos.usuarios){
            println("esto: "+eve.nombre+ " " + eve.apellido)
        }


        try {
            eventosService.save(eventos)
        } catch (ValidationException e) {
            respond eventos.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'eventos.label', default: 'Eventos'), eventos.id])
                redirect eventos
            }
            '*' { respond eventos, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond eventosService.get(id)
    }

    def update(Eventos eventos) {
        if (eventos == null) {
            notFound()
            return
        }

        try {
            eventosService.save(eventos)
        } catch (ValidationException e) {
            respond eventos.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'eventos.label', default: 'Eventos'), eventos.id])
                redirect eventos
            }
            '*'{ respond eventos, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        eventosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'eventos.label', default: 'Eventos'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventos.label', default: 'Eventos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
