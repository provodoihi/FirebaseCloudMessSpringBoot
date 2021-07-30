package com.example.demo;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class Controller {
	
	@Autowired
	private FCM_Service fcm_Service;
	
	private java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());
	
	@PostMapping("/api")
	public Map<String, String> sendNotification(@RequestBody MessageRequest messageRequest) {
		logger.info("Send to token: " + messageRequest.getToken());
		logger.info("Message: " + messageRequest.getMessage());
		return Collections.singletonMap("response", fcm_Service.pushNotification(messageRequest));
	}
}
