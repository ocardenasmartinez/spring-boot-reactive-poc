package cl.service.poc.infra.secundary.dao;

import cl.service.poc.infra.secundary.dao.collections.CharacterCollection;
import cl.service.poc.core.domain.RickAndMorty;
import cl.service.poc.core.domain.RickAndMortyLocation;
import cl.service.poc.core.domain.SaveCharacter;
import cl.service.poc.properties.PropertiesConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@AllArgsConstructor
public class RickAndMortyDAOImpl implements RickAndMortyDAO {

    private CharacterReactiveRepository characterReactiveRepository;
    private WebClient webClient;
    private PropertiesConfig propertiesConfig;


    @Override
    public Mono<RickAndMorty> getRickAndMortyDTO(Integer id) {
        return webClient.get().uri(propertiesConfig.getUrl().concat(String.valueOf(id)))
                .retrieve()
                .bodyToMono(RickAndMorty.class);
    }

    @Override
    public Mono<RickAndMortyLocation> getRickAndMortyLocationDTO(String url) {
        return webClient.get().uri(url)
                .retrieve()
                .bodyToMono(RickAndMortyLocation.class);
    }

    @Override
    public Mono<SaveCharacter> saveCharacterById(Integer id) {
        return getRickAndMortyDTO(id).map(rickAndMortyDTO -> {
            var characterCollection = CharacterCollection.builder();
            characterCollection.idCharacter(rickAndMortyDTO.getId());
            characterCollection.episodeCount(rickAndMortyDTO.getEpisode().size());
            characterCollection.name(rickAndMortyDTO.getName());
            characterCollection.status(rickAndMortyDTO.getStatus());
            characterCollection.species(rickAndMortyDTO.getSpecies());
            return characterReactiveRepository.save(characterCollection.build());
        }).map(characterCollectionMono -> characterCollectionMono
                .map(characterCollection -> {
                    var saveCharacter = SaveCharacter.builder();
                    saveCharacter.idCharacter(characterCollection.getIdCharacter());
                    saveCharacter.episodeCount(characterCollection.getEpisodeCount());
                    saveCharacter.name(characterCollection.getName());
                    saveCharacter.species(characterCollection.getSpecies());
                    saveCharacter.status(characterCollection.getStatus());
                    return saveCharacter.build();
                }))
                .flatMap(Mono::from);
    }

    @Override
    public Flux<SaveCharacter> getAllCharacter() {
        return characterReactiveRepository.findAll().map(characterCollection -> {
            var saveCharacter = SaveCharacter.builder();
            saveCharacter.idCharacter(characterCollection.getIdCharacter());
            saveCharacter.episodeCount(characterCollection.getEpisodeCount());
            saveCharacter.name(characterCollection.getName());
            saveCharacter.species(characterCollection.getSpecies());
            saveCharacter.status(characterCollection.getStatus());
            return saveCharacter.build();
        });
    }

}
