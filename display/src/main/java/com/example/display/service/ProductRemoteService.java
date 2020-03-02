package com.example.display.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProductRemoteService {
    private final String url = "http://product/api/products/";
    private final RestTemplate restTemplate;

    @HystrixCommand(commandKey = "getProduct", fallbackMethod = "getProductFallback")
    public String getProduct(String displayId){
        return restTemplate.getForObject(url + (displayId + 1), String.class);
    }

    public String getProductFallback(String displayId, Throwable t){
//        throw new Exception("new Exception");
        System.out.println("t: " + t);
        return "product fallBackMethod Call";
    }
}
