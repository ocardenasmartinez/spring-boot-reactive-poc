package cl.mobdev.rickandmorty.business

import cl.mobdev.rickandmorty.dao.RickAndMortyDAO
import cl.mobdev.rickandmorty.dto.CharacterDTO
import cl.mobdev.rickandmorty.dto.OriginDTO
import cl.mobdev.rickandmorty.dto.RickAndMortyDTO
import cl.mobdev.rickandmorty.dto.RickAndMortyLocationDTO
import cl.mobdev.rickandmorty.dto.RickAndMortyOriginDTO
import org.springframework.boot.origin.Origin
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
