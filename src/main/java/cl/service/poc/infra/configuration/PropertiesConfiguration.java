package cl.service.poc.infra.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        PropertiesConfig.class
})
public class PropertiesConfiguration {
    
}
