package com.example.ecommercekafka.controllers;

import com.example.ecommercekafka.dto.OrderDTO;
import com.example.ecommercekafka.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.management.monitor.MonitorNotification;
import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Mono<ResponseEntity> newOrder(@RequestBody @Valid OrderDTO dto) {
        orderService.newOrder(dto);
        return Mono.just(ResponseEntity.status(HttpStatus.CREATED).build());
    }
}
