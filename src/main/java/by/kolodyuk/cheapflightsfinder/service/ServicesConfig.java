package by.kolodyuk.cheapflightsfinder.service;

import by.kolodyuk.cheapflightsfinder.client.ClientsConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import(ClientsConfig.class)
@ComponentScan("by.kolodyuk.cheapflightsfinder.service")
public class ServicesConfig {
}
