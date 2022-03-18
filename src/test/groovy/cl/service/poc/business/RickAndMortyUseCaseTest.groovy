package cl.service.poc.business

import cl.service.poc.core.RickAndMortyUseCase
import cl.service.poc.core.service.RickAndMorty
import cl.service.poc.dao.RickAndMortyDAO
import cl.service.poc.dto.Origin
import cl.service.poc.dto.RickAndMortyLocation
import cl.service.poc.dto.RickAndMortyOrigin
import spock.lang.Specification

class RickAndMortyUseCaseTest extends Specification {

    RickAndMortyDAO rickAndMortyDAO = Mock()

    RickAndMortyUseCase rickAndMorty = new RickAndMorty(rickAndMortyDAO)

     def"RickAndMorty successful"(){
         given:
         def rickAndMortyLocationDTO = new RickAndMortyLocation()
         rickAndMortyLocationDTO.setName("")

         def rickAndMortyOriginDTO = new RickAndMortyOrigin()
         rickAndMortyOriginDTO.setName("")

         def rickAndMortyDTO = new RickAndMortyUseCase()
         rickAndMortyDTO.setId(1)
         rickAndMortyDTO.setOrigin(rickAndMortyOriginDTO)
         rickAndMortyDTO.setLocation(rickAndMortyLocationDTO)
         rickAndMortyDTO.setEpisode(List.of(""))

         and:
         def characterDTO = Character.builder()
         characterDTO.id(1)
         characterDTO.episodeCount(1)
         characterDTO.origin(Origin.builder().build())

         when:
         def response = rickAndMorty.getCharacterById(1)

         then:
         1 * rickAndMortyDAO.getRickAndMortyDTO(_) >> rickAndMortyDTO
         1 * rickAndMortyDAO.getRickAndMortyLocationDTO(_) >> rickAndMortyLocationDTO

         and:
         response == characterDTO.build()

    }

}
