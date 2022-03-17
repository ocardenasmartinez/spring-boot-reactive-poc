package cl.mobdev.rickandmorty.configuration;

import cl.mobdev.rickandmorty.properties.PropertiesConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        PropertiesConfig.class
})
public class PropertiesConfiguration {
    
}
