package cl.mobdev.rickandmorty.dao;

import cl.mobdev.rickandmorty.dto.RickAndMortyDTO;
import cl.mobdev.rickandmorty.dto.RickAndMortyLocationDTO;
import cl.mobdev.rickandmorty.properties.PropertiesConfig;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
@AllArgsConstructor
public class RickAndMortyDAOImpl implements RickAndMortyDAO{

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

}
