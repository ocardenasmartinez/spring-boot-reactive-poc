package cl.service.poc.controllers


import cl.service.poc.business.RickAndMorty
import cl.service.poc.dto.CharacterDTO
import spock.lang.Specification

class RickAndMortyControllerTest extends Specification {

    RickAndMorty rickAndMorty = Mock()

    RickAndMortyController rickAndMortyController = new RickAndMortyController(rickAndMorty)

    def"RickAndMortyController successful"() {
        given:
        def characterDTO = CharacterDTO.builder()
        characterDTO.id(1)

        when:
        def response = rickAndMortyController.getCharacterById(1)

        then:
        1 * rickAndMorty.getCharacterById(_) >> characterDTO.build()

        and:
        response.getBody() == characterDTO.build()


    }

}
