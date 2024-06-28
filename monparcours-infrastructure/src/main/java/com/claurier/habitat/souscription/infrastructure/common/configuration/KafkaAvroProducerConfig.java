package com.claurier.habitat.souscription.infrastructure.common.configuration;

import com.claurier.habitat.souscription.infrastructure.configuration.KafkaProducerConfiguration;
import com.claurier.habitat.souscription.infrastructure.event.consumer.Key;
import com.claurier.habitat.souscription.infrastructure.kafka.KafkaProducerConfigurationBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;

/* à remettre claurier
@Configuration
@Import(
{
    KafkaProducerConfiguration.class
})
@ConditionalOnProperty(value = "kafka.enabled", havingValue = "true", matchIfMissing = true)
@EnableKafka
 */

public class KafkaAvroProducerConfig
{
    /* à remettre claurier
    public KafkaAvroProducerConfig(KafkaProducerConfigurationBuilder kafkaProducerConfigurationBuilder)

    {
        this.kafkaProducerConfigurationBuilder = kafkaProducerConfigurationBuilder;
    }
    @Bean
    public KafkaProducer<Key, EventOnOpportunity> eventonOpportunityKafkaProducer()
    {
        return kafkaProducerConfigurationBuilder.buildProducer();
    } */
}
