package by.kolodyuk.cheapflightsfinder.service;

import by.kolodyuk.cheapflightsfinder.client.ClientsConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ClientsConfig.class)
@ComponentScan("by.kolodyuk.cheapflightsfinder.service")
public class ServicesConfig {
}
