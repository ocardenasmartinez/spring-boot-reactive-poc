package cl.service.poc.configuration;

import cl.service.poc.business.RickAndMorty;
import cl.service.poc.business.RickAndMortyImpl;
import cl.service.poc.dao.RickAndMortyDAO;
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
