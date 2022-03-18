package cl.service.poc.configuration;

import graphql.kickstart.tools.SchemaParserOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Configuration
public class GraphqlConfiguration {
    @Bean
    public List<SchemaParserOptions.GenericWrapper> genericWrappers() {
        return List.of(
                SchemaParserOptions.GenericWrapper.withTransformer(Mono.class, 0, Mono::toFuture, t -> t),
                SchemaParserOptions.GenericWrapper.listCollectionWithTransformer(Flux.class, 0, Flux -> Flux.collectList().toFuture())
        );
    }
}