package com.example.order.controller;

import com.example.order.client.UserClient;
import com.example.order.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final UserClient userClient;
    private final List<Order> orders = new CopyOnWriteArrayList<>();

    public OrderController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping
    public List<Order> list() {
        return orders;
    }

    @PostMapping
    public Order create(@RequestParam Long userId, @RequestParam String product) {
        Order order = new Order((long) (orders.size() + 1), userId, product);
        orders.add(order);
        return order;
    }

    /**
     * 演示服务间调用：聚合订单与其所属用户信息。
     */
    @GetMapping("/{id}/with-user")
    public Map<String, Object> orderWithUser(@PathVariable Long id) {
        Order order = orders.stream()
                .filter(o -> o.id().equals(id))
                .findFirst()
                .orElse(null);
        if (order == null) {
            return Map.of("error", "order not found");
        }
        return Map.of("order", order, "user", userClient.getUser(order.userId()));
    }
}
