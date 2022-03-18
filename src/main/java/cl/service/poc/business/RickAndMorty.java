package cl.service.poc.business;

import cl.service.poc.dto.CharacterDTO;
import cl.service.poc.dto.SaveCharacterDTO;
import reactor.core.publisher.Mono;

public interface RickAndMorty {

    Mono<CharacterDTO> getCharacterById(Integer id);
    Mono<SaveCharacterDTO> saveCharacterById(Integer id);

}
