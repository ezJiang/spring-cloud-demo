package com.example.user.controller;

import com.example.user.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    // 演示用内存数据源（生产请替换为数据库）
    private final List<User> users = new CopyOnWriteArrayList<>(List.of(
            new User(1L, "Alice", "alice@example.com"),
            new User(2L, "Bob", "bob@example.com")
    ));

    @GetMapping
    public List<User> list() {
        return users;
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return users.stream()
                .filter(u -> u.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
