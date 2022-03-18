package cl.service.poc.core;

import cl.service.poc.core.domain.Character;
import cl.service.poc.core.domain.SaveCharacter;
import reactor.core.publisher.Mono;

public interface RickAndMortyUseCase {

    Mono<Character> getCharacterById(Integer id);
    Mono<SaveCharacter> saveCharacterById(Integer id);

}
