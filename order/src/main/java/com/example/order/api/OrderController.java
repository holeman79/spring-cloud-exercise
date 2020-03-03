package com.example.order.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    @Value("${spring.kafka.topic.orderCreated}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/{orderId}")
    public void getOrder(@PathVariable("orderId") String orderId){
        System.out.println(String.format("orderId : %s, topic: %s ", orderId, topic));
        kafkaTemplate.send(topic, topic + " data");
    }
}
