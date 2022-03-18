package cl.service.poc.business

import cl.service.poc.dao.RickAndMortyDAO
import cl.service.poc.dto.CharacterDTO
import cl.service.poc.dto.OriginDTO
import cl.service.poc.dto.RickAndMortyDTO
import cl.service.poc.dto.RickAndMortyLocationDTO
import cl.service.poc.dto.RickAndMortyOriginDTO
import spock.lang.Specification

class RickAndMortyTest extends Specification {

    RickAndMortyDAO rickAndMortyDAO = Mock()

    RickAndMorty rickAndMorty = new RickAndMortyImpl(rickAndMortyDAO)

     def"RickAndMorty successful"(){
         given:
         def rickAndMortyLocationDTO = new RickAndMortyLocationDTO()
         rickAndMortyLocationDTO.setName("")

         def rickAndMortyOriginDTO = new RickAndMortyOriginDTO()
         rickAndMortyOriginDTO.setName("")

         def rickAndMortyDTO = new RickAndMortyDTO()
         rickAndMortyDTO.setId(1)
         rickAndMortyDTO.setOrigin(rickAndMortyOriginDTO)
         rickAndMortyDTO.setLocation(rickAndMortyLocationDTO)
         rickAndMortyDTO.setEpisode(List.of(""))

         and:
         def characterDTO = CharacterDTO.builder()
         characterDTO.id(1)
         characterDTO.episodeCount(1)
         characterDTO.origin(OriginDTO.builder().build())

         when:
         def response = rickAndMorty.getCharacterById(1)

         then:
         1 * rickAndMortyDAO.getRickAndMortyDTO(_) >> rickAndMortyDTO
         1 * rickAndMortyDAO.getRickAndMortyLocationDTO(_) >> rickAndMortyLocationDTO

         and:
         response == characterDTO.build()

    }

}
