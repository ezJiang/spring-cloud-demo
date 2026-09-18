package com.example.order.model;

/**
 * 订单服务侧的 User DTO（与 user-service 的 User 结构保持一致，用于 Feign 反序列化）。
 */
public record User(Long id, String name, String email) {
}
