package com.claurier.habitat.souscription.infrastructure.common.configuration;

import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

/* à remettre claurier
@Configuration
@Import(
        {
                KafkaConsumerConfiguration.class,
        })
@ConditionalOnProperty(
        value = "kafka.enabled",
        havingValue = "true",
        matchIfMissing = true)
@EnableKafka */
public class KafkaAvroConsumerConfig
{

    /* à remettre claurier
    private final KafkaConsumerConfigurationBuilder kafkaConsumerConfigurationBuilder;


    private final String creSiclidCreationNumeroDossierConsumerGroup;

    private final String creSiclidCreationNumeroDossierAutoOffsetReset;

    public KafkaAvroConsumerConfig(
            KafkaConsumerConfigurationBuilder kafkaConsumerConfigurationBuilder,
            @Value("${kafka.consumergroup.consumer_group_cre_creation_numero_dossier}") String creSiclidCreationNumeroDossierConsumerGroup,
            @Value("${kafka.cre-creation-numero-dossier.auto-offset-reset: latest}") String creSiclidCreationNumeroDossierAutoOffsetReset) {
        this.kafkaConsumerConfigurationBuilder = kafkaConsumerConfigurationBuilder;
        this.creSiclidCreationNumeroDossierConsumerGroup = creSiclidCreationNumeroDossierConsumerGroup;
        this.creSiclidCreationNumeroDossierAutoOffsetReset = creSiclidCreationNumeroDossierAutoOffsetReset;

    }

    public ConsumerFactory<String, Object> kafkaConsumerFactory(String groupId, boolean useSpecificAvroReader, String autoOffsetReset) {
        Map<String, Object> configuration = kafkaConsumerConfigurationBuilder.consumerConfiguration();
        configuration.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        // https://medium.com/lydtech-consulting/kafka consumer cuto-offset reset d3962bad2665
        // earliest -> lors de l'activation de la consommation (10 1ere fois), on va consommer tout l'historique stocké du message.
        // A voir quelle est la durée de rétention du message (30) Urs en général), cela peut correspondre à des dizaines de milliers de messages -> cela prend du temps...
        // Question à se poser : a-t-on besoin de l'historique ?
        // latest (default)-> Lors de l'activation de la consommotor (Lc lère fois), on va consommer les nouveaux messages qui arrivent
        // NB une fois passée le lère consommation, les messages sont ensuite traités au fil de l'eau.
        configuration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        configuration.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        configuration.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, "3000");
        configuration.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "45000");
        // usespecificvroReader -> false st on utilise CeneracRecord, si por exemple on avait :
        //    public class XXXConsumer implements Consumer consumerRecordsGenericRecord, GenericRecord>> {
        // https://docs.confluent. to/platform/current/schema-registry/schema_registry onprem_tutorial.html#java-consumers
        configuration.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, useSpecificAvroReader);
        return new DefaultKafkaConsumerFactory<>(configuration);
    }

    public ConsumerFactory<String, Object> kafkaConsumerFactory(String groupId, String autoOffsetReset) {
        return kafkaConsumerFactory(groupId, true, autoOffsetReset);
    }

    public ConsumerFactory<String, Object> kafkaConsumerFactory(String groupId) {
        return kafkaConsumerFactory(groupId, true, "latest");
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> creSiclidCreationNumeroDossierAvroKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(kafkaConsumerFactory(cresiclidCreationNumeroDossierConsumerGroup, cresiclidCreationNumeroDossierAutoOffsetReset));
        return factory;

    }
     */
}

