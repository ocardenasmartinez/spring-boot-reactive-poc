package cl.service.poc.infra.primary.controllers;

import cl.service.poc.core.RickAndMortyUseCase;
import cl.service.poc.core.domain.Character;
import cl.service.poc.core.domain.SaveCharacter;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class RickAndMortyGraphql implements GraphQLQueryResolver {

    private final RickAndMortyUseCase rickAndMortyUseCase;

    public Mono<Character> getCharacterById(Integer id) {
        return rickAndMortyUseCase.getCharacterById(id);
    }

    public Mono<SaveCharacter> saveCharacterById(Integer id) {
        return rickAndMortyUseCase.saveCharacterById(id);
    }

}