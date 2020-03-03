package com.example.product.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/{productId}")
    public String getProduct(@PathVariable String productId){
//        throw new RuntimeException("Exception~!~!!!");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "this product id : " + productId  + " at " + System.currentTimeMillis() + "]";
    }



    @KafkaListener(topics = "${spring.kafka.topic.orderCreated}")
    public void listen(@Payload String message) {
        LOG.info("received message='{}'", message);
    }
}
