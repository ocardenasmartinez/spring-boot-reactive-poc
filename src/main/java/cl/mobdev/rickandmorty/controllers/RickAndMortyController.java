package cl.mobdev.rickandmorty.controllers;

import cl.mobdev.rickandmorty.business.RickAndMorty;
import cl.mobdev.rickandmorty.dto.CharacterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class RickAndMortyController {

    private final RickAndMorty rickAndMorty;

    @GetMapping("/getcharacter")
    public Mono<CharacterDTO> getCharacterById(@RequestParam("id") Integer id) {
        return rickAndMorty.getCharacterById(id);
    }

}