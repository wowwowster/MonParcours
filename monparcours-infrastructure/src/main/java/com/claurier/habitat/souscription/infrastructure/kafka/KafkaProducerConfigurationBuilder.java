package com.claurier.habitat.souscription.infrastructure.kafka;

import com.claurier.habitat.souscription.infrastructure.kafka.configuration.property.KafkaProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe contenant toutes les propriétés correspondant aux producers kafka/schema-registry, et permettant de
 générer une configuration de producer kafka.
 */
public class KafkaProducerConfigurationBuilder
{
    // Properties keys
    private static final String PROP_SCHEMA_REGISTRY_SSL_KEY_PASSWORD = "schema.registry.ssl.key.password";
    private static final String PROP_SCHEMA_REGISTRY_SSL_KEYSTORE_LOCATION =

            "schema.registry.ssl. keystore.location";
    private static final String PROP_SCHEMA_REGISTRY_SSL_KEYSTORE_PASSWORD = "schema.registry.ssl.keystore.password";
    private static final String PROP_SCHEMA_REGISTRY_SSL_TRUSTSTORE_LOCATION = "schema.registry.ssl.truststore. location";
    private static final String PROP_SCHEMA_REGISTRY_SSL_TRUSTSTORE_PASSWORD = "schema.registry.ssl. truststore.password";
    private static final String PROP_SECURITY_PROTOCOL = "security.protocol";
    // Properties values
    private static final String ACKS_CONFIG_VALUE = "all";
    private static final int MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION_VALUE = 1;
    private static final String SECURITY_PROTOCOL_VALUE = "SSL";

    /** Propriétés liées à kafka, qui ne doivent pas être modifiés au cours de la vie du bean. */
    private final KafkaProperties properties;
    /** Nom de l'application. */
    private final String appName;

    public KafkaProducerConfigurationBuilder(KafkaProperties properties, String appName)
    {
        this.properties = properties;
        this.appName = appName;
    }

    /**
     * Génère une {@link Map} contenant la configuration du producer.
     */
    public Map<String, Object> producerConfiguration()
    {
        Map<String, Object> configuration = new HashMap<>();

        /* claurier à remettre
        configuration.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers().getUrl());
        
        configuration.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        configuration.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        configuration.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,
                          MAX IN FLIGHT_REQUESTS_PER_CONNECTION_VALUE);
        configuration.put(ProducerConfig.ACKS_CONFIG, ACKS_CONFIG_VALUE);
        configuration.put(ProducerConfig.CLIENT_ID_CONFIG, appName);
        configuration.put(AbstractKafka Schema SerDeConfig. SCHEMA_REGISTRY_URL_CONFIG,
                          properties.getSchema Registry().getUrl());
        configuration.put(AbstractKafka Schema SerDeConfig. AUTO_REGISTER_SCHEMAS,
                          properties.getSchema Registry().isAutoRegisterSchemas() );
        
        boolean idempotenceEnabled = !isNull(properties.getIdempotence()) &&
                                     properties.getIdempotence().isEnabled();
        configuration.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, idempotenceEnabled);
        if (properties.getSsl().isEnabled()) {
            configuration.put(PROP_SECURITY_PROTOCOL, SECURITY_PROTOCOL_VALUE);
            configuration.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG,
                              properties.getBootstrapServers ().getSsl ().getKeyPassword());
            configuration.put(SslConfigs.SSL_KEYSTORE LOCATION_CONFIG,
                              properties.getBootstrapServers ().getSsl().getKeyStoreLocation());
            configuration.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG,
                              properties.getBootstrapServers ().getSsl ().getKeyStorePassword());
            configuration.put(SslConfigs.SSL_TRUSTSTORE LOCATION_CONFIG,
                              properties.getBootstrapServers ().getSsl().getTrustStoreLocation());
            configuration.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG,
                              properties.getBootstrapServers ().getSsl().getTrustStorePassword());
            configuration.put(PROP_SCHEMA_REGISTRY_SSL_KEY_PASSWORD,
                              properties.getSchema Registry().getSsl().getKeyPassword());
            configuration.put(PROP_SCHEMA_REGISTRY_SSL_KEYSTORE LOCATION,
                              properties.getSchema Registry().getSsl().getKeyStoreLocation());
            configuration.put(PROP_SCHEMA_REGISTRY_SSL_KEYSTORE PASSWORD,
                              properties.getSchema Registry().getSsl().getKeyStorePassword());
            configuration.put(PROP_SCHEMA_REGISTRY_SSL_TRUSTSTORE LOCATION,
                              properties.getSchemaRegistry().getSsl().getTrustStoreLocation());
            configuration.put(PROP_SCHEMA_REGISTRY_SSL_TRUSTSTORE_PASSWORD,
                              properties.getSchema Registry().getSsl().getTrustStorePassword());
        }*/
        return configuration;
    }

    /* Génère un (@link KafkaProducer à partir de la configuration initialisée dans ce builder.
     * @param <KEY> Le type de la clef des messages Kafka à envoyer.
     * @param <VALUE> Le type de la valeur des messages Kafka à envoyer.
     */
    /* claurier à remettre public <KEY, VALUE> KafkaProducer<KEY, VALUE> build
    Producer () {
        Map<String, Object> configuration = producerConfiguration();
        DefaultKafkaProducerFactory<KEY, VALUE> producerFactory = new DefaultKafka Producer Factory<> (configuration);
        KafkaTemplate<KEY, VALUE> kafkaTemplate = new KafkaTemplate<> (producerFactory);
        return new KafkaProducer<> (kafkaTemplate);
    }*/
}
