package cl.service.poc.controllers;

import cl.service.poc.business.RickAndMorty;
import cl.service.poc.dto.CharacterDTO;
import cl.service.poc.dto.SaveCharacterDTO;
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

    public Mono<SaveCharacterDTO> saveCharacterById(Integer id) {
        return rickAndMorty.saveCharacterById(id);
    }

}