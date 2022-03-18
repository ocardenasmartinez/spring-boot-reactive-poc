package cl.service.poc.infra.primary.controllers;

import cl.service.poc.core.RickAndMortyUseCase;
import cl.service.poc.core.domain.Character;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class RickAndMortyController {

    private final RickAndMortyUseCase rickAndMortyUseCase;

    @GetMapping("/getcharacter")
    public Mono<Character> getCharacterById(@RequestParam("id") Integer id) {
        return rickAndMortyUseCase.getCharacterById(id);
    }

}