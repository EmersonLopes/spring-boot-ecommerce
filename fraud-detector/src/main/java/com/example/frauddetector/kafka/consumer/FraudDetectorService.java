package com.example.frauddetector.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectorService {

    @KafkaListener(topics = "orders")
    public void consume(String message){
        System.out.println("Received Message: " + message);
    }
}
