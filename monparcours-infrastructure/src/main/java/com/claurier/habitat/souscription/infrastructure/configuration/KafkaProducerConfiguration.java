package com.claurier.habitat.souscription.infrastructure.configuration;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan(basePackageClasses = KafkaProperties.class)
public class KafkaProducerConfiguration
{

    /* claurier à remettre
    @Bean
    
    public KafkaProducerConfiguration BuilderkafkaProducerProperties(KafkaProperties kafkaProperties, @Value("${application.name}") String appName)
    {
        return new KafkaProducerConfigurationBuilder(kafkaProperties, appName);
    }
    
     */
}
