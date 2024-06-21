package com.claurier.habitat.souscription.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("dev")
@PropertySource("classpath:extraEnv.properties")
public class PropertiesWithProfiles {

}
