package cl.service.poc

import cl.service.poc.dao.RickAndMortyDAO
import cl.service.poc.dao.RickAndMortyDAOImpl
import cl.service.poc.dto.RickAndMorty
import cl.service.poc.infra.configuration.PropertiesConfig
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class RickAndMortyUseCaseDAOTest extends Specification {

    PropertiesConfig propertiesConfig = Mock()
    RestTemplate restTemplate = Mock {
        def rickAndMortyDTO = new RickAndMorty()
        rickAndMortyDTO.setId(1)
        getForEntity(_ as String, RickAndMorty.class) >> new ResponseEntity(rickAndMortyDTO, HttpStatus.OK)
    }

    RickAndMortyDAO rickAndMortyDAO = new RickAndMortyDAOImpl(restTemplate, propertiesConfig)

    def"RickAndMortyDAOI successful"() {
        given:
        def rickAndMortyDTO = new RickAndMorty()
        rickAndMortyDTO.setId(1)

        when:
        def response = rickAndMortyDAO.getRickAndMortyDTO(1)

        then:
        1 * propertiesConfig.getUrl() >> "http://www.google.com/"

        and:
        response == rickAndMortyDTO

    }

}
