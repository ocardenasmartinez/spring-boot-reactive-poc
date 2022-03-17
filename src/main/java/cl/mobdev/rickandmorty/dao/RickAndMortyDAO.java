package cl.mobdev.rickandmorty.dao;

import cl.mobdev.rickandmorty.dto.RickAndMortyDTO;
import cl.mobdev.rickandmorty.dto.RickAndMortyLocationDTO;
import reactor.core.publisher.Mono;

public interface RickAndMortyDAO {

    Mono<RickAndMortyDTO> getRickAndMortyDTO(Integer id);
    Mono<RickAndMortyLocationDTO> getRickAndMortyLocationDTO(String url);

}
