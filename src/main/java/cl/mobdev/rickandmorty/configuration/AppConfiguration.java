package cl.mobdev.rickandmorty.configuration;

import cl.mobdev.rickandmorty.business.RickAndMorty;
import cl.mobdev.rickandmorty.business.RickAndMortyImpl;
import cl.mobdev.rickandmorty.dao.RickAndMortyDAO;
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
    public RickAndMorty rickAndMorty(RickAndMortyDAO rickAndMortyDAO) {
        return new RickAndMortyImpl(rickAndMortyDAO);
    }

}
