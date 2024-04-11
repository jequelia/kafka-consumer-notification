package com.notification.email.domain.notification;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;

    private final EmailSenderService emailSenderService;

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws Exception{
        log.info("message consumed {}", message);
        Notification notification = objectMapper.readValue(message, Notification.class);

        emailSenderService.sendNotification(notification);
    }

}