package cl.mobdev.rickandmorty.business;

import cl.mobdev.rickandmorty.dto.CharacterDTO;
import reactor.core.publisher.Mono;

public interface RickAndMorty {

    Mono<CharacterDTO> getCharacterById(Integer id);

}
