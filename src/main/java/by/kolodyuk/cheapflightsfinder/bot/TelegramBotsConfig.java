package by.kolodyuk.cheapflightsfinder.bot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@Configuration
public class TelegramBotsConfig {

    static {
        ApiContextInitializer.init();
    }

    @Bean
    TelegramBotsApi telegramBotsApi(TelegramBot telegramBot) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        telegramBotsApi.registerBot(telegramBot);

        return telegramBotsApi;
    }

}
