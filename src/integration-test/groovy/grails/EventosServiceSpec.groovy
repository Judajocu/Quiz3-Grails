package grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EventosServiceSpec extends Specification {

    EventosService eventosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Eventos(...).save(flush: true, failOnError: true)
        //new Eventos(...).save(flush: true, failOnError: true)
        //Eventos eventos = new Eventos(...).save(flush: true, failOnError: true)
        //new Eventos(...).save(flush: true, failOnError: true)
        //new Eventos(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //eventos.id
    }

    void "test get"() {
        setupData()

        expect:
        eventosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Eventos> eventosList = eventosService.list(max: 2, offset: 2)

        then:
        eventosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        eventosService.count() == 5
    }

    void "test delete"() {
        Long eventosId = setupData()

        expect:
        eventosService.count() == 5

        when:
        eventosService.delete(eventosId)
        sessionFactory.currentSession.flush()

        then:
        eventosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Eventos eventos = new Eventos()
        eventosService.save(eventos)

        then:
        eventos.id != null
    }
}
