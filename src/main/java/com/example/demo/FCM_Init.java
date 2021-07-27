package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FCM_Init {
	@PostConstruct
    public void init() throws FileNotFoundException {
        try {
        	String path = "C:\\Users\\Chae Young\\Documents\\test_firebase\\src\\main\\resources\\agoraapp-d0c80-firebase-adminsdk-zt7so-383a86bac5.json";
        	FileInputStream inputStream = new FileInputStream(path);
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(inputStream))
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            System.err.print(e);
        }
    }

}
