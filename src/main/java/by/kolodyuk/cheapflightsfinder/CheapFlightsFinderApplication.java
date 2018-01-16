package by.kolodyuk.cheapflightsfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class CheapFlightsFinderApplication {

    static {
        ApiContextInitializer.init();
    }

    public static void main(String[] args) {
        SpringApplication.run(CheapFlightsFinderApplication.class, args);
    }
}
