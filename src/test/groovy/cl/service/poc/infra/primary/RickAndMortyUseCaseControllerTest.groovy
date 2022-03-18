package cl.service.poc.infra.primary


import cl.service.poc.core.RickAndMortyUseCase
import spock.lang.Specification

class RickAndMortyUseCaseControllerTest extends Specification {

    RickAndMortyUseCase rickAndMorty = Mock()

    RickAndMortyRest rickAndMortyController = new RickAndMortyRest(rickAndMorty)

    def"RickAndMortyController successful"() {
        given:
        def characterDTO = Character.builder()
        characterDTO.id(1)

        when:
        def response = rickAndMortyController.getCharacterById(1)

        then:
        1 * rickAndMorty.getCharacterById(_) >> characterDTO.build()

        and:
        response.getBody() == characterDTO.build()


    }

}
