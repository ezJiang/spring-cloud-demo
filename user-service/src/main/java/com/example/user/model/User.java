package com.example.user.model;

/**
 * 使用 Java 17 record 作为不可变数据载体（DTO）。
 */
public record User(Long id, String name, String email) {
}
