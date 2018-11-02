package grails

import grails.gorm.services.Service

@Service(Eventos)
interface EventosService {

    Eventos get(Serializable id)

    List<Eventos> list(Map args)

    Long count()

    void delete(Serializable id)

    Eventos save(Eventos eventos)

}