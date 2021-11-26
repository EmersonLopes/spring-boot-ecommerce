package com.example.ecommercekafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaSenderService {

    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaSenderService.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic, Object msg) {
        ListenableFuture<SendResult<String, Object>> sender = kafkaTemplate.send(topic, msg);
        sender.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("unable to send message= " + msg, ex);
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                LOGGER.info("sent message= " + result + " with offset= " + result.getRecordMetadata().offset());
            }


        });
    }
}
