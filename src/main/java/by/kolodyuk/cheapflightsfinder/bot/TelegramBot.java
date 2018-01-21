package by.kolodyuk.cheapflightsfinder.bot;

import by.kolodyuk.cheapflightsfinder.service.CompositeCheapFlightsService;
import by.kolodyuk.cheapflightsfinder.service.TelegramClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@Component
@ManagedResource
public class TelegramBot extends TelegramLongPollingBot {

    private static final Logger LOGGER = LoggerFactory.getLogger(TelegramBot.class);

    @Value("${telegram.bot.name}")
    private String name;
    @Value("${telegram.bot.token}")
    private String token;

    @Autowired
    private CompositeCheapFlightsService compositeCheapFlightsService;
    @Autowired
    private TelegramClientService telegramClientService;

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();
        telegramClientService.saveClientChat(chatId);
        sendFlightSummaryToChat(chatId);
    }

    @ManagedOperation
    public void sendTextMessage(long chatId, String text) {
        try {
            SendMessage message = new SendMessage().setChatId(chatId).setText(text);
            execute(message);
        } catch (TelegramApiException e) {
            LOGGER.error("Failed to send text message to chatId {} ", chatId);
        }
    }

    @ManagedOperation
    public void sendTextMessage(String text) {
        telegramClientService.findAllClientChats()
                .forEach(chatId -> sendTextMessage(chatId, text));
    }

    private void sendFlightSummaryToChat(long chatId) {
        try {
            sendTextMessage(chatId, compositeCheapFlightsService.findCheapFlightsExtendedString());
        } catch (RestClientException e) {
            LOGGER.error("Failed to send flight summary to chat {}", chatId);
        }
    }

    @Scheduled(cron = "0 0 13 * * *")
    public void sendFlightSummary() {
        telegramClientService.findAllClientChats()
                .forEach(this::sendFlightSummaryToChat);
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return name;
    }
}
