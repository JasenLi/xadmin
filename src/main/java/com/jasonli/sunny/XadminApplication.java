package com.jasonli.sunny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lijunsong
 * @date 2019/3/1 20:18
 * @since 1.0
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.jasonli.sunny")
public class XadminApplication {
    public static void main(String[] args) {
        SpringApplication.run(XadminApplication.class, args);
    }
}
