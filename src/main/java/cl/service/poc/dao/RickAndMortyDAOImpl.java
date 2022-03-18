package cl.service.poc.dao;

import cl.service.poc.collections.CharacterCollection;
import cl.service.poc.dto.RickAndMortyDTO;
import cl.service.poc.dto.RickAndMortyLocationDTO;
import cl.service.poc.dto.SaveCharacterDTO;
import cl.service.poc.properties.PropertiesConfig;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@AllArgsConstructor
public class RickAndMortyDAOImpl implements RickAndMortyDAO{

    private CharacterReactiveRepository characterReactiveRepository;
    private WebClient webClient;
    private PropertiesConfig propertiesConfig;


    @Override
    public Mono<RickAndMortyDTO> getRickAndMortyDTO(Integer id) {
        return webClient.get().uri(propertiesConfig.getUrl().concat(String.valueOf(id)))
                .retrieve()
                .bodyToMono(RickAndMortyDTO.class);
    }

    @Override
    public Mono<RickAndMortyLocationDTO> getRickAndMortyLocationDTO(String url) {
        return webClient.get().uri(url)
                .retrieve()
                .bodyToMono(RickAndMortyLocationDTO.class);
    }

    @Override
    public Mono<SaveCharacterDTO> saveCharacterById(Integer id) {
        return getRickAndMortyDTO(id).map(rickAndMortyDTO -> {
            var characterCollection = CharacterCollection.builder();
            characterCollection.idCharacter(rickAndMortyDTO.getId());
            characterCollection.episodeCount(rickAndMortyDTO.getEpisode().size());
            characterCollection.name(rickAndMortyDTO.getName());
            characterCollection.status(rickAndMortyDTO.getStatus());
            characterCollection.species(rickAndMortyDTO.getSpecies());
            return characterReactiveRepository.save(characterCollection.build());
        }).map(characterCollectionMono -> characterCollectionMono.map(CharacterCollection::getId).map(x -> {
            log.info(x);
            return SaveCharacterDTO.builder().id(x).build();
        })).flatMap(Mono::from);
    }

}
