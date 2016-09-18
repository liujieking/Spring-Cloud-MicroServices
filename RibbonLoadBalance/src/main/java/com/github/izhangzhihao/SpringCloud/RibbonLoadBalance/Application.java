package com.github.izhangzhihao.SpringCloud.RibbonLoadBalance;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon负载均衡
 */
@EnableCircuitBreaker//开启断路器
@EnableDiscoveryClient//添加发现服务
@SpringBootApplication
public class Application {

    @Bean
    @LoadBalanced//开启均衡负载
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}