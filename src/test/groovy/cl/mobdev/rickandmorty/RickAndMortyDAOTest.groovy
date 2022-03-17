package cl.mobdev.rickandmorty

import cl.mobdev.rickandmorty.dao.RickAndMortyDAO
import cl.mobdev.rickandmorty.dao.RickAndMortyDAOImpl
import cl.mobdev.rickandmorty.dto.RickAndMortyDTO
import cl.mobdev.rickandmorty.properties.PropertiesConfig
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class RickAndMortyDAOTest extends Specification {

    PropertiesConfig propertiesConfig = Mock()
    RestTemplate restTemplate = Mock {
        def rickAndMortyDTO = new RickAndMortyDTO()
        rickAndMortyDTO.setId(1)
        getForEntity(_ as String, RickAndMortyDTO.class) >> new ResponseEntity(rickAndMortyDTO, HttpStatus.OK)
    }

    RickAndMortyDAO rickAndMortyDAO = new RickAndMortyDAOImpl(restTemplate, propertiesConfig)

    def"RickAndMortyDAOI successful"() {
        given:
        def rickAndMortyDTO = new RickAndMortyDTO()
        rickAndMortyDTO.setId(1)

        when:
        def response = rickAndMortyDAO.getRickAndMortyDTO(1)

        then:
        1 * propertiesConfig.getUrl() >> "http://www.google.com/"

        and:
        response == rickAndMortyDTO

    }

}
