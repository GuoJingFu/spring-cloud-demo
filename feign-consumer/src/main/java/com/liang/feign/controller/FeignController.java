package com.liang.feign.controller;

import com.liang.feign.service.FeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author  lianghaiyang 2019/2/25 19:47
 */
@RestController
public class FeignController {
    @Resource
    FeignService feignService;

    @GetMapping(value = "/v1/port")
    public String printPort() {
        return feignService.printPort();
    }
}
