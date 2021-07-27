package com.example.demo;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

@Service
public class FCM_Service {
	public String pushNotification(MessageRequest messageRequest) {
        Message message = Message.builder()
                .putData("message", messageRequest.getMessage())
                .setToken(messageRequest.getToken())
                .build();

        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        return response;
    }
}
