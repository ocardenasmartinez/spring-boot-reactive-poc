package cl.service.poc.core.service;

import cl.service.poc.core.RickAndMortyUseCase;
import cl.service.poc.core.port.secundary.RickAndMortyPort;
import cl.service.poc.core.domain.Character;
import cl.service.poc.core.domain.Origin;
import cl.service.poc.core.domain.SaveCharacter;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

import static java.util.Optional.ofNullable;

@RequiredArgsConstructor
public class RickAndMorty implements RickAndMortyUseCase {

    private final RickAndMortyPort rickAndMortyDAO;

    @Override
    public Mono<Character> getCharacterById(Integer id) {
        return rickAndMortyDAO.getRickAndMortyDTO(id)
                .map(rickAndMortyDTO -> {
                    ofNullable(rickAndMortyDTO.getOrigin())
                            .orElseThrow(RuntimeException::new);
                    ofNullable(rickAndMortyDTO.getOrigin().getUrl())
                            .orElseThrow(RuntimeException::new);
                    return rickAndMortyDTO;
                })
                .map(rickAndMortyDTO -> rickAndMortyDAO.getRickAndMortyLocationDTO(rickAndMortyDTO.getOrigin().getUrl())
                        .map(rickAndMortyLocationDTO -> {
                            var originDTO = Origin.builder();
                            var characterDTO = Character.builder();
                            characterDTO.id(rickAndMortyDTO.getId());
                            var episodes = ofNullable(rickAndMortyDTO.getEpisode())
                                    .orElseGet(ArrayList::new);
                            characterDTO.episodeCount(episodes.size());
                            characterDTO.type(rickAndMortyDTO.getType());
                            characterDTO.species(rickAndMortyDTO.getSpecies());
                            characterDTO.name(rickAndMortyDTO.getName());
                            characterDTO.status(rickAndMortyDTO.getStatus());
                            originDTO.residents(rickAndMortyLocationDTO.getResidents());
                            originDTO.dimension(rickAndMortyLocationDTO.getDimension());
                            originDTO.url(rickAndMortyLocationDTO.getUrl());
                            originDTO.name(rickAndMortyLocationDTO.getName());
                            characterDTO.origin(originDTO.build());
                            return characterDTO.build();
                        })).flatMap(Mono::from);
    }

    @Override
    public Mono<SaveCharacter> saveCharacterById(Integer id) {
        return rickAndMortyDAO.saveCharacterById(id);
    }

}
