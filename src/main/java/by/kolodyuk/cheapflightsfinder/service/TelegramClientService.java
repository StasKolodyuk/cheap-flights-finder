package by.kolodyuk.cheapflightsfinder.service;

import by.kolodyuk.cheapflightsfinder.model.TelegramClient;
import by.kolodyuk.cheapflightsfinder.repository.TelegramClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelegramClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TelegramClientService.class);

    @Autowired
    private TelegramClientRepository telegramClientRepository;

    @Transactional
    public List<Long> findAllClientChats() {
        return telegramClientRepository.findAll()
                                       .stream()
                                       .map(TelegramClient::getChatId)
                                       .collect(Collectors.toList());
    }

    @Transactional
    public void saveClientChat(long chatId) {
        if (telegramClientRepository.findByChatId(chatId) == null) {
            LOGGER.info("Saving chat {}", chatId);
            telegramClientRepository.save(TelegramClient.of(chatId));
        }
    }

}
