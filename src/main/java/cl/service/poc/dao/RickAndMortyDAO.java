package cl.service.poc.dao;

import cl.service.poc.dto.RickAndMortyDTO;
import cl.service.poc.dto.RickAndMortyLocationDTO;
import cl.service.poc.dto.SaveCharacterDTO;
import reactor.core.publisher.Mono;

public interface RickAndMortyDAO {

    Mono<RickAndMortyDTO> getRickAndMortyDTO(Integer id);
    Mono<RickAndMortyLocationDTO> getRickAndMortyLocationDTO(String url);
    Mono<SaveCharacterDTO> saveCharacterById(Integer id);

}
