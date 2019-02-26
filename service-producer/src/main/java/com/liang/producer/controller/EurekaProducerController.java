package com.liang.producer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lianghaiyang
 * @date 2019/02/25
 */
@RestController
public class EurekaProducerController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/v1/port")
    public Object printPort() {
        return port;
    }
}
