package by.kolodyuk.cheapflightsfinder.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TELEGRAM_CLIENT")
@EntityListeners(AuditingEntityListener.class)
public class TelegramClient {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private UUID id;
    @Column(name = "CHAT_ID", unique = true, nullable = false)
    private Long chatId;
    @CreatedDate
    @Column(name = "CREAT_TS", nullable = false)
    private LocalDateTime createdTimestamp;

    public static TelegramClient of(long chatId) {
        TelegramClient telegramClient = new TelegramClient();
        telegramClient.setChatId(chatId);

        return telegramClient;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

}
