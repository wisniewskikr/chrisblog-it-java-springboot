package com.example.configs;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.example.repositories")
public class CassandraConfig extends AbstractCassandraConfiguration {

    /*
     * Provide a keyspace name to the configuration.
     */
    @Override
    protected String getKeyspaceName() {
        return "mykeyspace";
    }

    /*
     * Automatically creates a Keyspace if it doesn't exist
     */
    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification
                .createKeyspace("mykeyspace").ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true).withSimpleReplication();
        return Arrays.asList(specification);
    }

    /*
     * Automatically configure a table if doesn't exist
     */
    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.RECREATE_DROP_UNUSED;
    }

    /*
     * Get the entity package (where the entity class has the @Table annotation)
     */
    @Override
    public String[] getEntityBasePackages() {
        return new String[] { "com.example.documents" };
    }
    
}
