package com.notification.email.domain.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderService {


    public void sendNotification(Notification notification) {

        System.out.println("Sending notification: " + notification);

    }


}
