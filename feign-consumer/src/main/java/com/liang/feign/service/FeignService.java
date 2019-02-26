package com.liang.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author  lianghaiyang 2019/2/25 19:36
 */
@FeignClient(value = "service-eureka")
public interface FeignService {
    /**
     * 获取端口
     * @return 端口号
     */
    @RequestMapping(value = "/v1/port",method = RequestMethod.GET)
    String printPort();
}
