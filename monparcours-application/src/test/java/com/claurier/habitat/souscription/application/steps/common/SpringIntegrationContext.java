package com.claurier.habitat.souscription.application.steps.common;

import com.claurier.habitat.souscription.application.configuration.Authorities;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;

/**
 * Configuration de Spring
 *
 * Mettre les beans à mocker ici (Les adapters de la couche infrastructure)
 * (à récupérer avec un @Autowired dans les classes steps)
 *
 * Ajouter les classes des services à injecter dans nos steps (Service, Domaine,...)
 */
@CucumberContextConfiguration
@SpringBootTest(classes = {
        SpringIntegrationContext.class, Authorities.class
})
@Primary
public class SpringIntegrationContext {
    /**
     * Example:
     * @MockBean
     * SouscriptionRepositoryPort souscriptionRepository;
     */
}
