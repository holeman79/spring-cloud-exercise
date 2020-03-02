package com.example.display.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product", fallbackFactory = FeignProductRemoteServiceFallbackFactory.class)
public interface FeignProductRemoteService {
    @GetMapping("/api/products/{productId}")
    String getProduct(@PathVariable("productId") String productId);

//    @GetMapping("/api/products/options/{optionId}")
//    String getProductOption(@PathVariable("optionId") String optionId);
}
