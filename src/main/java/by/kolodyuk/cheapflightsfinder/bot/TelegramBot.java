package by.kolodyuk.cheapflightsfinder.bot;

import by.kolodyuk.cheapflightsfinder.controller.CheapFlightsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.HashSet;
import java.util.Set;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    private CheapFlightsController cheapFlightsController;
    private Set<Long> chatIds = new HashSet<>();

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();
        chatIds.add(chatId);
        sendFlightSummaryToChat(chatId);
    }

    private void sendFlightSummaryToChat(long chatId) {
        try {
            SendMessage message = new SendMessage().setChatId(chatId)
                                                   .setText(cheapFlightsController.findCheapFlightsAsString());

            execute(message);
        } catch (RestClientException e) {
            System.out.println("rest client ex" + e);
        } catch (TelegramApiException e) {
            System.out.println("telegram ex" + e);
        }
    }

    @Scheduled(cron = "0 0 13 * * *")
    public void sendFlightSummary() {
        chatIds.forEach(this::sendFlightSummaryToChat);
    }

    @Override
    public String getBotToken() {
        return "479810030:AAFk6PCmyEvV3cCaGLMB2nAnyLSgQBXCyfw";
    }

    @Override
    public String getBotUsername() {
        return "CheapFlightsFinderBot";
    }
}
