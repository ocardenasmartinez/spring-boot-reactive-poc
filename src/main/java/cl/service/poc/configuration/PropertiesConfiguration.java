package cl.service.poc.configuration;

import cl.service.poc.properties.PropertiesConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        PropertiesConfig.class
})
public class PropertiesConfiguration {
    
}
