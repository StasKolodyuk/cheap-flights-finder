package by.kolodyuk.cheapflightsfinder.repository;

import by.kolodyuk.cheapflightsfinder.model.TelegramClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TelegramClientRepository extends JpaRepository<TelegramClient, UUID> {

    TelegramClient findByChatId(long chatId);

}
