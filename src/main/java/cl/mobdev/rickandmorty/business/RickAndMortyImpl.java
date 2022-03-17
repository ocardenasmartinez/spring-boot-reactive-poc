package cl.mobdev.rickandmorty.business;

import cl.mobdev.rickandmorty.dao.RickAndMortyDAO;
import cl.mobdev.rickandmorty.dto.CharacterDTO;
import cl.mobdev.rickandmorty.dto.OriginDTO;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

import static java.util.Optional.ofNullable;

@RequiredArgsConstructor
public class RickAndMortyImpl implements RickAndMorty {

    private final RickAndMortyDAO rickAndMortyDAO;

    @Override
    public Mono<CharacterDTO> getCharacterById(Integer id) {
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
                            var originDTO = OriginDTO.builder();
                            var characterDTO = CharacterDTO.builder();
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

}
