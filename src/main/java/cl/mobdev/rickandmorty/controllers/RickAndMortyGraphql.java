package cl.mobdev.rickandmorty.controllers;

import cl.mobdev.rickandmorty.business.RickAndMorty;
import cl.mobdev.rickandmorty.dto.CharacterDTO;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class RickAndMortyGraphql implements GraphQLQueryResolver {

    private final RickAndMorty rickAndMorty;

    public Mono<CharacterDTO> getCharacterById(Integer id) {
        return rickAndMorty.getCharacterById(id);
    }

}