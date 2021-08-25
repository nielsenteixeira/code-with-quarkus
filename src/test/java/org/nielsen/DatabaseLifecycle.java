package org.nielsen;

import io.quarkus.test.common.QuarkusTestResourceConfigurableLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;
import java.util.Map;

public class DatabaseLifecycle implements QuarkusTestResourceConfigurableLifecycleManager {
    PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:9.6");

    @Override
    public Map<String, String> start() {
        postgres.start();

        var properties = new HashMap<String, String>();
        properties.put("quarkus.datasource.jdbc.url", postgres.getJdbcUrl());
        properties.put("quarkus.datasource.username", postgres.getUsername());
        properties.put("quarkus.datasource.password", postgres.getPassword());
        return properties;
    }

    @Override
    public void stop() {
        if (postgres != null) {
            postgres.stop();
        }
    }
}
