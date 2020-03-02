package com.example.display.api;

import com.example.display.service.FeignProductRemoteService;
import com.example.display.service.ProductRemoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api//displays")
@RequiredArgsConstructor
public class DisplayController {
    private final ProductRemoteService productRemoteService;
    private final FeignProductRemoteService feignProductRemoteService;

    @GetMapping("/{displayId}")
    public String getDisplay(@PathVariable String displayId){
        return String.format("Display Id : %s at %s Product Id : %s", displayId, System.currentTimeMillis(), getProduct(displayId));
    }

    public String getProduct(String displayId){
        return feignProductRemoteService.getProduct(displayId);
//        return productRemoteService.getProduct(displayId);
    }
}
