package cl.service.poc.infra.secundary.dao;

import cl.service.poc.core.domain.RickAndMorty;
import cl.service.poc.core.domain.RickAndMortyLocation;
import cl.service.poc.core.domain.SaveCharacter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RickAndMortyDAO {

    Mono<RickAndMorty> getRickAndMortyDTO(Integer id);
    Mono<RickAndMortyLocation> getRickAndMortyLocationDTO(String url);
    Mono<SaveCharacter> saveCharacterById(Integer id);
    Flux<SaveCharacter> getAllCharacter();

}
