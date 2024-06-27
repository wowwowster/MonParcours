package com.claurier.habitat.souscription.application;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/integration/features",
        plugin = {
                "pretty",
                "html:target/cucumber.html"
        },
        tags = "not @TODO",
        glue = {
                "com.claurier.habitat.souscription.application.steps.common",
                "com.claurier.habitat.souscription.application.steps.integration"
        })
public class CucumberIntegrationTest {

}
