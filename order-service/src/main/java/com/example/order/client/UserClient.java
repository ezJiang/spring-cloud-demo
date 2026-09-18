package com.example.order.client;

import com.example.order.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 声明式 HTTP 客户端：通过服务名 user-service 调用用户服务。
 * Spring Cloud OpenFeign 会基于 Eureka 注册表做客户端负载均衡（spring-cloud-loadbalancer）。
 */
@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/users")
    List<User> listUsers();

    @GetMapping("/users/{id}")
    User getUser(@PathVariable("id") Long id);
}
