package com.marktechie.Blog.config;


import com.marktechie.Blog.utils.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(DatabaseConfiguration.class)
public class DatabaseConnectionConfiguration {

    private final DatabaseConfiguration databaseConfiguration;

    @Profile("dev")
    @Bean
    public String getConnectionConfig() {
        Logger.getLogger().printMessage("Configuration for Dev");
        var message = "URL:%s%nDriver Class Name: %s%nUsername: %s%nPassword: %s%n".formatted(
                databaseConfiguration.getUrl(),
                databaseConfiguration.getPassword(),
                databaseConfiguration.getDriverClassName(),
                databaseConfiguration.getUsername()
        );
        Logger.getLogger().printMessage(message);
        return "Database Configured for Development";
    }

    @Profile("prod")
    @Bean
    public String getProdConnectionConfig() {
        Logger.getLogger().printMessage("Configuration for Prod");
        var message = "URL:%s%nDriver Class Name: %s%nUsername: %s%nPassword: %s%n".formatted(
                databaseConfiguration.getUrl(),
                databaseConfiguration.getPassword(),
                databaseConfiguration.getDriverClassName(),
                databaseConfiguration.getUsername()
        );
        Logger.getLogger().printMessage(message);
        return "Database Configured for Development";
    }

    @Profile("default")
    @Bean
    public String getDefaultConnectionConfig() {
        Logger.getLogger().printMessage("Configuration for Def");
        var message = "URL:%s%nDriver Class Name: %s%nUsername: %s%nPassword: %s%n".formatted(
                databaseConfiguration.getUrl(),
                databaseConfiguration.getPassword(),
                databaseConfiguration.getDriverClassName(),
                databaseConfiguration.getUsername()
        );
        Logger.getLogger().printMessage(message);
        return "Database Configured for Development";
    }
}
