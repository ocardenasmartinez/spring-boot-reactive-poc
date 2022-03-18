package cl.service.poc.infra.configuration;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "mobdev.rickandmorty")
public class PropertiesConfig {
    private String url;
}
