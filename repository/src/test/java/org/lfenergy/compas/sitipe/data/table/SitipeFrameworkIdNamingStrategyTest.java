package org.lfenergy.compas.sitipe.data.table;

import io.smallrye.config.ConfigValuePropertiesConfigSource;
import io.smallrye.config.SmallRyeConfig;
import io.smallrye.config.SmallRyeConfigBuilder;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;
import org.eclipse.microprofile.config.spi.ConfigSource;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SitipeFrameworkIdNamingStrategyTest {

    private SitipeFrameworkIdNamingStrategy sut;

    private final String frameworkId = "123";

    @BeforeEach
    public void setUp() {
        final Map<String, String> configMap = new HashMap<>();
        configMap.put("compas.sitipe.framework-id", frameworkId);

        SmallRyeConfig config = new SmallRyeConfigBuilder()
                .withSources(new ConfigValuePropertiesConfigSource(configMap, "CONFIG", 0))
                .build();
        ConfigProviderResolver.instance().registerConfig(config, Thread.currentThread().getContextClassLoader());

        sut = new SitipeFrameworkIdNamingStrategy();
    }

    @AfterEach
    public void tearDown() {
        ConfigProviderResolver.instance().releaseConfig(ConfigProvider.getConfig());
    }

    @Test
    public void itShouldSetCorrectNamingWhenHasFrameworkId() {
        final String tableName = "TABLE";

        final Identifier identifier = mock(Identifier.class);
        final JdbcEnvironment environment = mock(JdbcEnvironment.class);

        when(identifier.getText()).thenReturn(tableName);

        final Identifier result = sut.toPhysicalTableName(identifier, environment);

        assertEquals("123__TABLE", result.getText());
    }

}