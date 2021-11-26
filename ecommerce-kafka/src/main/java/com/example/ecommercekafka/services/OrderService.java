package com.example.ecommercekafka.services;

import com.example.ecommercekafka.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private KafkaSenderService kafkaSenderService;

    @Value(value = "${topics.orders}")
    private String topicOrders;

    public void newOrder(OrderDTO dto) {
        kafkaSenderService.sendMessage(topicOrders, dto);
    }


}
