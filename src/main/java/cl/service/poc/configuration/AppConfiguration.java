package cl.service.poc.configuration;

import cl.service.poc.core.RickAndMortyUseCase;
import cl.service.poc.core.service.RickAndMorty;
import cl.service.poc.infra.secundary.dao.RickAndMortyDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfiguration {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    @Bean
    public RickAndMortyUseCase rickAndMorty(RickAndMortyDAO rickAndMortyDAO) {
        return new RickAndMorty(rickAndMortyDAO);
    }

}
