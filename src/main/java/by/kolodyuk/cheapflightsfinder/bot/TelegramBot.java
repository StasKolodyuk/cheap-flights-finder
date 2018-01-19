package by.kolodyuk.cheapflightsfinder.bot;

import by.kolodyuk.cheapflightsfinder.client.ryanair.RyanairClient;
import by.kolodyuk.cheapflightsfinder.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    private RyanairClient ryanairClient;
    private Set<Long> chatIds = new HashSet<>();

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();
        chatIds.add(chatId);
        sendFlightSummaryToChat(chatId);
    }

    private void sendFlightSummaryToChat(long chatId) {
        try {
            List<Flight> flights = ryanairClient.getFlightsSummary();


            SendMessage message = new SendMessage()
                    .setChatId(chatId)
                    .setText(flights.stream().map(Object::toString).collect(Collectors.joining("\n")));

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
